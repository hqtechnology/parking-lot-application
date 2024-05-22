import React, { useEffect } from 'react';

import { json, redirect } from 'react-router-dom';

import { googleLogout } from '@react-oauth/google';
import { useAuth } from '../AuthContext';

function Logout() {
  // useEffect(() => {
  //   action();
  // }, [localStorage.getItem('token')]);

  // const {logout} = useAuth();

  return (
    <React.Fragment>
      <h2>Logged out</h2>
    </React.Fragment>
  );
}

// export function logoutLoader() {
//   return action();
// }

export default Logout;
