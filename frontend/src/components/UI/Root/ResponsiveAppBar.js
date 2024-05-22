import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import { useNavigate, useRouteLoaderData } from 'react-router-dom';
import { Form } from 'react-router-dom';
import { useAuth } from '../../auth/AuthContext';

function ResponsiveAppBar() {
  const { isLoggedIn, logout } = useAuth();

  const handleLogout = () => {
    logout();
  };

  const navigate = useNavigate();
  const token = useRouteLoaderData('root');

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          {/* <a href="ui"> */}
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="#"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            HQueue
          </Typography>
          {/* </a> */}

          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            <Button
              key="page1"
              onClick={() => {
                navigate('/ui');
              }}
              sx={{ my: 2, color: 'white', display: 'block' }}
            >
              home
            </Button>
            <Button
              key="page2"
              onClick={() => {
                navigate('/ui/users');
              }}
              sx={{ my: 2, color: 'white', display: 'block' }}
            >
              Users
            </Button>
            <Button
              key="page3"
              onClick={() => {
                navigate('/ui/parking');
              }}
              sx={{ my: 2, color: 'white', display: 'block' }}
            >
              Parking
            </Button>

            {!isLoggedIn && (
              <Button
                key="login"
                onClick={() => {
                  navigate('/ui/login');
                }}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                Login
              </Button>
            )}
            {isLoggedIn && (
              <Form action="/logout" method="post">
                <Button
                  key="logout"
                  onClick={handleLogout}
                  sx={{ my: 2, color: 'white', display: 'block' }}
                >
                  Logout
                </Button>
              </Form>
            )}
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default ResponsiveAppBar;
