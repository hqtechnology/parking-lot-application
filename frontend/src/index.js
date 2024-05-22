import ReactDOM from 'react-dom/client';
import React from 'react';

import './index.css';
import App from './App';
import { GoogleOAuthProvider } from '@react-oauth/google';
import { AuthProvider } from './components/auth/AuthContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <GoogleOAuthProvider clientId="764592178505-4srkusqoarts7udmmsgt5q74sh7hvhhc.apps.googleusercontent.com">
    <AuthProvider>
      <React.StrictMode>
        <App />
      </React.StrictMode>
    </AuthProvider>
  </GoogleOAuthProvider>
);
