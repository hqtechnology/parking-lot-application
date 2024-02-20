import { useParams } from 'react-router-dom';

function UserDetails() {
  const params = useParams();
  return (
    <>
      <h1>User details</h1>
      <p>UserId: {params.userId}</p>
    </>
  );
}

export default UserDetails;
