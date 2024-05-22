import { NavLink } from 'react-router-dom';
import Button from '../UI/Button/Button';

function LoginRedirect() {
  return (
    <NavLink to="/login">
      <Button>Login</Button>
    </NavLink>
  );
}

export default LoginRedirect;
