import React from 'react';
import { NavLink } from 'react-router-dom';
import classes from './ParkingNav.module.css';

const ParkingNav = (params) => {
  return (
    <header className={classes.header}>
      <nav>
        <ul className={classes.list}>
          <li>
            <NavLink
              to="/ui/parking/park"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
              end
            >
              Park a Vehicle
            </NavLink>
          </li>

          <li>
            <NavLink
              to="/ui/parking/unpark"
              className={({ isActive }) =>
                isActive ? classes.active : undefined
              }
            >
              UnPark a Vehicle
            </NavLink>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default ParkingNav;
