import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import ErrorLayout from './components/Error/Error';
import Login from './components/Login/Login';
import Logout from './components/Login/Logout';
import RootLayout from './components/UI/Root/Root';
import Users from './components/UI/Users/Users';
import Admin from './components/UI/Admin/Admin';
import { AuthContextProvider } from './store/auth-context';
import Vehicle from './components/UI/Velicles/Vehicle';
import Home from './components/UI/Home/Home';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <ErrorLayout />,
    children: [
      { path: '/', element: <Home /> },
      { path: '/login', element: <Login /> },
      { path: '/logout', element: <Logout /> },
      { path: '/users', element: <Users /> },
      { path: '/admin', element: <Admin /> },
    ],
  },
  { path: '/vehicles', element: <Vehicle />, errorElement: <ErrorLayout /> },
]);

function App() {
  return (
    <AuthContextProvider>
      <RouterProvider router={router} />
    </AuthContextProvider>
  );
}

export default App;
