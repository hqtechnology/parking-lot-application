import AuthContext from '../../../store/auth-context';
import { useContext } from 'react';
import classes from './Home.module.css';

function Home() {
  const ctx = useContext(AuthContext);
  return (
    <div className={classes.home}>
      <h2>Home Page</h2>
    </div>
  );
}

export default Home;
