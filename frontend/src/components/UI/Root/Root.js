import { Outlet } from 'react-router-dom';
import MainNavigation from '../../Nav/MainNavigation';
import { useContext } from 'react';
import AuthContext from '../../../store/auth-context';

function RootLayout() {
  const ctx = useContext(AuthContext);
  return (
    <>
      <MainNavigation />
      <main>
        <Outlet />
      </main>
    </>
  );
}

export default RootLayout;
