import ParkingNav from './ParkingNav';
import { Outlet } from 'react-router-dom';

function ParkingLayout() {
  return (
    <>
      <ParkingNav />
      <main>
        <Outlet />
      </main>
    </>
  );
}

export default ParkingLayout;
