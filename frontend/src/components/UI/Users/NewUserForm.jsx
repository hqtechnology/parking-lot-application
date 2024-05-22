import { InputLabel, Input, Container, Grid, Button } from '@mui/material';

import classes from './NewUserForm.module.css';
import { Form, useActionData } from 'react-router-dom';

function NewUserForm() {
  const data = useActionData();

  return (
    <Container className={classes.container}>
      <Form method="post" className={classes.form}>
        <Grid container spacing={1}>
          <Grid item xs={4}>
            <InputLabel htmlFor="user-email" className={classes.inputLabel}>
              Email address
            </InputLabel>
            <Input
              id="user-email"
              aria-describedby="user-email-helper-text"
              className={classes.input}
              type="email"
              required={true}
            >
              Email address
            </Input>
          </Grid>
          <Grid item xs={4}>
            <InputLabel htmlFor="user-username" className={classes.inputLabel}>
              Username
            </InputLabel>
            <Input
              id="user-username"
              aria-describedby="user-username-helper-text"
              className={classes.input}
              required={true}
              type="text"
            />
          </Grid>
          <Grid item xs={4}>
            <InputLabel htmlFor="user-passcode" className={classes.inputLabel}>
              Passcode
            </InputLabel>
            <Input
              id="user-passcode"
              aria-describedby="user-passcode-helper-text"
              className={classes.input}
              required={true}
            />
          </Grid>
          <Grid item xs={12}>
            <Button type="submit" className={classes.button}>
              Submit
            </Button>
          </Grid>
        </Grid>
      </Form>
    </Container>
  );
}

export default NewUserForm;
