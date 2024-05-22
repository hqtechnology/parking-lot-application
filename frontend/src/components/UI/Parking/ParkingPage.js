// import { Container } from 'semantic-ui-react';
import { Button, Container } from '@mui/material';
import classes from './ParkingPage.module.css';

function ParkingPage() {
  return (
    <Container maxWidth="lg" className={classes.container}>
      <Button className={classes.button} onClick={() => {}}>
        find free slots
      </Button>
    </Container>
  );
}

export default ParkingPage;
