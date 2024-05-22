import { Form, useNavigation } from 'react-router-dom';
import classes from './UnParkForm.module.css';
import { useState } from 'react';
import { getAuthToken } from '../../auth/auth';
// import { NotificationPopup } from 'react-native-push-notification-popup';

function UnParkForm() {
  const navigation = useNavigation();
  const isSubmitting = navigation.state === 'submitting';
  const serverUrl = window.location.origin + window.location.pathname;
  const token = getAuthToken();

  const [ticketId, setTicketId] = useState(undefined);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setTicketId({ ...ticketId, [name]: value });

    // console.log('handleInputChange: ' + ticketId);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const queryParams = new URLSearchParams(ticketId).toString();
    // console.log('Server req: ' + serverUrl + `?${queryParams}`);
    const response = await fetch(serverUrl + `?${queryParams}`, {
      method: 'POST',
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });

    // if (!response.ok) {
    //   throw json(
    //     { message: `Couldn't unpark ${queryParams}` },
    //     { status: response.status }
    //   );
    // }

    console.log(response);
  };

  return (
    <>
      <Form method="post" className={classes.form} onSubmit={handleSubmit}>
        <p>
          <label htmlFor="ticketId">TicketId: </label>
          <input
            id="ticketId"
            type="text"
            name="ticketId"
            onChange={handleInputChange}
            required
          />
        </p>
        <div className={classes.actions}>
          <button type="submit" disabled={isSubmitting}>
            {isSubmitting ? 'Submitting...' : 'Submit'}
          </button>
        </div>
      </Form>
      {/* <NotificationPopup ref={(ref) => (this.popup = ref)} />; */}
    </>
  );
}

export default UnParkForm;
