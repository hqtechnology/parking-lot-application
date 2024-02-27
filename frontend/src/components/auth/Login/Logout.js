import React from 'react';

import { redirect } from 'react-router-dom';

export function action() {
  localStorage.removeItem('token');
  localStorage.removeItem('expiration');
  return redirect('/');
}

function Logout() {
  return (
    <React.Fragment>
      <h2>Logged out</h2>
    </React.Fragment>
  );
}

export default Logout;
