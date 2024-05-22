import { Container } from '@mui/material';
import classes from './UnParkingPage.module.css';
import UnParkForm from './UnParkForm';

const UnParkingPage = (params) => {
  return (
    <Container className={classes.container} maxWidth="lg">
      <UnParkForm />
    </Container>
  );
};

export default UnParkingPage;
