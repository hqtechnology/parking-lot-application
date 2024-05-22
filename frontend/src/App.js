import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import ErrorLayout from './components/Error/Error';
import Login, {
  action as authAction,
} from './components/auth/LoginAndLogout/Login';
import Logout, {
  action as logoutAction,
  logoutLoader,
} from './components/auth/LoginAndLogout/Logout';
import RootLayout from './components/UI/Root/Root';
import UsersLayout from './components/UI/Users/UsersLayout';
import Vehicle from './components/UI/Velicles/Vehicle';
import Home from './components/UI/Home/Home';
import UserDetails from './components/UI/Users/UserDetails';
import { tokenLoader } from './components/auth/auth';
import UsersPage, {
  loader as userPageLoader,
} from './components/UI/Users/UsersPage';
import EditUserPage from './components/UI/Users/EditUserPage';
import ParkingLayout from './components/UI/Parking/ParkingLayout';
import ParkingPage from './components/UI/Parking/ParkingPage';
import UnParkingPage from './components/UI/Parking/UnParkingPage';
import NewUser, { onSubmitNewUser } from './components/UI/Users/NewUser';

const router = createBrowserRouter([
  {
    path: 'ui',
    element: <RootLayout />,
    id: 'root',
    errorElement: <ErrorLayout />,
    loader: tokenLoader,
    children: [
      { index: true, element: <Home /> },
      {
        path: 'login',
        element: <Login />,
        // action: authAction,
      },
      {
        path: 'auth',
        element: <Login />,
        // action: authAction,
      },
      {
        path: 'logout',
        element: <Logout />,
        // action: logoutAction,
        // loader: logoutLoader,
      },
      {
        path: 'parking',
        element: <ParkingLayout />,
        errorElement: <ErrorLayout />,
        children: [
          {
            path: 'park',
            element: <ParkingPage />,
            index: false,
          },
          {
            path: 'unpark',
            element: <UnParkingPage />,
            index: false,
          },
        ],
      },
      {
        path: 'users',
        element: <UsersLayout />,
        children: [
          {
            index: true,
            element: <UsersPage />,
            loader: userPageLoader,
          },
          {
            path: 'new',
            element: <NewUser />,
            action: onSubmitNewUser,
          },
          {
            path: ':userId',
            id: 'user-details',
            children: [
              {
                index: true,
                element: <UserDetails />,
              },
              {
                path: 'edit',
                element: <EditUserPage />,
              },
            ],
          },
        ],
      },
    ],
  },
  { path: 'vehicles', element: <Vehicle />, errorElement: <ErrorLayout /> },
]);

function App() {
  // return (
  //   <GoogleOAuthProvider clientId="764592178505-4srkusqoarts7udmmsgt5q74sh7hvhhc.apps.googleusercontent.com">
  //     <RouterProvider router={router} />
  //   </GoogleOAuthProvider>
  // );
  return <RouterProvider router={router} />;
}

export default App;
