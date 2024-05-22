import { NavLink } from 'react-router-dom';
import classes from './UserNavigation.module.css';
import { getAuthToken } from '../../auth/auth';

function UserNavigation() {
  const token = getAuthToken();
  return (
    <header className={classes.header}>
      {token && (
        <nav>
          <ul className={classes.list}>
            <li>
              <NavLink
                to="/ui/users"
                className={({ isActive }) =>
                  isActive ? classes.active : undefined
                }
                end
              >
                All Users
              </NavLink>
            </li>

            <li>
              <NavLink
                to="/ui/users/new"
                className={({ isActive }) =>
                  isActive ? classes.active : undefined
                }
              >
                New User
              </NavLink>
            </li>
          </ul>
        </nav>
      )}
    </header>
  );
}

export default UserNavigation;
