import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import ErrorLayout from './components/Error/Error';
import Login, { action as authAction } from './components/auth/Login/Login';
import Logout, { action as logoutAction } from './components/auth/Login/Logout';
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

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    id: 'root',
    errorElement: <ErrorLayout />,
    loader: tokenLoader,
    children: [
      { index: true, element: <Home /> },
      {
        path: 'login',
        element: <Login />,
        action: authAction,
      },
      {
        path: 'auth',
        element: <Login />,
        action: authAction,
      },
      {
        path: 'logout',
        element: <Logout />,
        action: logoutAction,
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
  return <RouterProvider router={router} />;
}

export default App;
