import { NavLink } from 'react-router-dom';
import classes from './UserNavigation.module.css';
import { getAuthToken } from '../../auth/auth';

function UserNavigation() {
  const token = getAuthToken();
  return (
    <header>
      <nav>
        <ul className={classes.list}>
          <li>
            <NavLink
              to="/users"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              All Users
            </NavLink>
          </li>
          {token && (
            <li>
              <NavLink
                to="/users/new"
                className={({ isActive }) =>
                  isActive ? classes.active : undefined
                }
              >
                New Event
              </NavLink>
            </li>
          )}
        </ul>
      </nav>
    </header>
  );
}

export default UserNavigation;
