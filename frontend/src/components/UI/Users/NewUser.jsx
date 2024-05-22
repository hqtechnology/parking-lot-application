import React from 'react';
import NewUserForm from './NewUserForm';

function NewUser(params) {
  return (
    <>
      <NewUserForm />
    </>
  );
}

export default NewUser;

export async function onSubmitNewUser({ request }) {
  console.log('Submit called by user ', request);
}
