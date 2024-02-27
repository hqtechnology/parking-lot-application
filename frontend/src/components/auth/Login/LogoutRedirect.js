import { NavLink } from 'react-router-dom';
import Button from '../UI/Button/Button';
import classes from './LogoutRedirect.module.css';

function LogoutRedirect() {
  return (
    <NavLink to="/logout" end>
      <Button className={classes.button}>Logout</Button>
    </NavLink>
  );
}

export default LogoutRedirect;
