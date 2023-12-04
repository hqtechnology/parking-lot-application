import React, { useContext } from 'react';
import AuthContext from '../../store/auth-context';

function Logout() {
  const ctx = useContext(AuthContext);
  return (
    <React.Fragment>
      {ctx.onLogout()}
      <h2>Logged out</h2>
    </React.Fragment>
  );
}

export default Logout;
