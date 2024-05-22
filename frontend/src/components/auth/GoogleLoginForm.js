import React from 'react';
import { GoogleLogin, useGoogleLogin } from '@react-oauth/google';
import { json, redirect } from 'react-router-dom';
import classes from './GoogleLoginForm.module.css';
import { useAuth } from './AuthContext';

function GoogleLoginForm() {
  const { login } = useAuth();

  const loginSuccess = async (response) => {
    const jwt = response.credential;
    const parts = jwt.split('.');
    const payload = parts[1];
    const jsonPayload = atob(payload).toString();

    const expiration = new Date();
    expiration.setHours(expiration.getHours() + 1);
    login({
      userDetails: jsonPayload,
      profile: jsonPayload,
      expiration: expiration.toString(),
      token: jwt,
    });
  };

  const errorRes = (error) => {
    throw json({ message: error.toString() }, { status: error.status });
  };

  return (
    <>
      {localStorage.getItem('loggedIn') ? (
        <div className={classes.div}>
          <p>Logged in.</p>
        </div>
      ) : (
        <div className={classes.div}>
          <h2>Google Login</h2>
          <GoogleLogin
            onSuccess={loginSuccess}
            onError={errorRes}
            buttonText="Login"
            cookiePolicy={'single_host_origin'}
          />
        </div>
      )}
    </>
  );
}

export default GoogleLoginForm;
