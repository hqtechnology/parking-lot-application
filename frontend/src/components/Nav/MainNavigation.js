import { NavLink, useRouteLoaderData, Form } from 'react-router-dom';
import classes from './MainNavigation.module.css';

const MainNavigation = () => {
  const token = useRouteLoaderData('root');

  return (
    <header className={classes.header}>
      <nav>
        <ul className={classes.list}>
          <li>
            <NavLink
              to="/"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              Home
            </NavLink>
          </li>
          <li>
            <NavLink
              to="users"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              Users
            </NavLink>
          </li>
          <li>
            <NavLink
              to="parking"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              Parking
            </NavLink>
          </li>
          {!token && (
            <li>
              <NavLink
                to="/auth?mode=login"
                className={({ isActive }) =>
                  isActive ? classes.active : undefined
                }
              >
                Login
              </NavLink>
            </li>
          )}
          {token && (
            <li>
              <Form action="/logout" method="post">
                <button>Logout</button>
              </Form>
            </li>
          )}
        </ul>
      </nav>
    </header>
  );
};

export default MainNavigation;
