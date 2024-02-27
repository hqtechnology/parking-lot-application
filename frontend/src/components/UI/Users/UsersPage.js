import UsersList from './UsersList';
import { Suspense } from 'react';
import { Await, useLoaderData, json, defer } from 'react-router-dom';

function UsersPage() {
  const { users } = useLoaderData();

  return (
    <Suspense fallback={<p style={{ textAlign: 'center' }}>Loading...</p>}>
      <Await resolve={users}>
        {(loadedEvents) => <UsersList users={loadedEvents} />}
      </Await>
    </Suspense>
  );
}

export default UsersPage;

async function loadEvents() {
  const serverUrl = window.location.origin + '/users';
  const token = localStorage.getItem('token');

  if (!token) {
    throw new Error('Token not found');
  }

  const response = await fetch(serverUrl, {
    method: 'GET',
    headers: {
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  });

  if (!response.ok) {
    // return { isError: true, message: 'Could not fetch users.' };
    // throw new Response(JSON.stringify({ message: 'Could not fetch events.' }), {
    //   status: 500,
    // });
    throw json(
      { message: 'Could not fetch users.' },
      {
        status: 500,
      }
    );
  } else {
    const resData = await response.json();
    return resData;
  }
}

export function loader() {
  return defer({
    users: loadEvents(),
  });
}
