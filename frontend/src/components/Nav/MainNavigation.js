import { React, useContext } from 'react';
import AuthContext from '../../store/auth-context';
import { NavLink } from 'react-router-dom';
import classes from './MainNavigation.module.css';
import LogoutRedirect from '../Login/LogoutRedirect';
import Button from '../UI/Button/Button';

const MainNavigation = () => {
  const ctx = useContext(AuthContext);
  return (
    <div>
      <nav>
        <div className={classes.navbar}>
          <div className={classes.logo}>
            <NavLink to="/">
              <img src="logo192.png" alt="Logo" />
            </NavLink>
          </div>
          <div className={classes.name}>
            <NavLink
              to="/"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              <h1>Parkinglot Application</h1>
            </NavLink>
          </div>

          {ctx.isLoggedIn && (
            <NavLink
              to="/users"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              Users
            </NavLink>
          )}
          {ctx.isLoggedIn && (
            <NavLink
              to="/admin"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              Admin
            </NavLink>
          )}
          {!ctx.isLoggedIn && (
            <NavLink
              to="/login"
              className={({ isActive }) =>
                isActive ? classes.disappear : undefined
              }
            >
              <Button>Login</Button>
            </NavLink>
          )}
          {ctx.isLoggedIn && <LogoutRedirect />}
        </div>
      </nav>
    </div>
  );
};

export default MainNavigation;
