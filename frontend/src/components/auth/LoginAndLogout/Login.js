// import AuthForm from '../AuthForm';

import { json, redirect } from 'react-router-dom';
import GoogleLoginForm from '../GoogleLoginForm';

function Login() {
  // return <AuthForm />;
  return <GoogleLoginForm />;
}

export default Login;

export async function action({ request }) {
  const searchParams = new URL(request.url).searchParams;
  const mode = searchParams.get('mode') || 'login';

  if (mode !== 'login' && mode !== 'signup') {
    throw json({ message: 'Unsupported mode.' }, { status: 422 });
  }

  const data = await request.formData();
  const authData = {
    email: data.get('email'),
    password: data.get('password'),
  };

  const serverUrl = window.location.origin;
  console.log('Server URL: ' + serverUrl);
  const response = await fetch(serverUrl + '/ui/' + mode, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(authData),
  });

  if (response.status === 422 || response.status === 401) {
    return response;
  }

  if (!response.ok) {
    throw json(
      { message: 'Could not authenticate user.' },
      { status: response.status }
    );
  }

  const resData = await response.json();
  console.log('resData ', resData);
  const token = resData.token;

  localStorage.setItem('token', token);
  const expiration = new Date();
  expiration.setHours(expiration.getHours() + 1);
  localStorage.setItem('expiration', expiration.toISOString());

  return redirect('/ui');
}
