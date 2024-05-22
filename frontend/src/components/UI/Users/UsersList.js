import React from 'react';
import classes from './UsersList.module.css';
import { Link } from 'react-router-dom';

function UsersList({ users }) {
  return (
    <div className={classes.users}>
      <ul className={classes.list}>
        {users && users.length > 0 && (
          <React.Fragment>
            <h1>All Users</h1>
            {users.map((user) => (
              <li key={user.id} className={classes.item}>
                <Link to={`/ui/users/${user.id}`}>
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
          </React.Fragment>
        )}
        {users && users.length <= 0 && <h1>No users found</h1>}
      </ul>
    </div>
  );
}

export default UsersList;
