import classes from './UsersList.module.css';
import { Link } from 'react-router-dom';

function UsersList({ users }) {
  return (
    <div className={classes.users}>
      <h1>All Users</h1>
      <ul className={classes.list}>
        {users.map((user) => (
          <li key={user.id} className={classes.item}>
            <Link to={`/users/${user.id}`}>
              {/* <img src={user.image} alt={user.title} /> */}
              <div className={classes.content}>
                <h2>UserId: {user.id}</h2>
                <p>
                  UserName: {user.name}
                  <br />
                  Email: {user.email}
                  <br />
                  Address: {user.address}
                </p>
              </div>
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UsersList;
