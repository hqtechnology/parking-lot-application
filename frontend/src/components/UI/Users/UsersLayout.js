import UserNavigation from './UserNavigation';
import { Outlet } from 'react-router-dom';

function UsersLayout() {
  return (
    <>
      <UserNavigation />
      <Outlet />
    </>
  );
}

export default UsersLayout;
