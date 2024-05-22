import { useRouteError } from 'react-router-dom';
import PageContent from '../UI/Pages/PageContent';

function ErrorLayout(props) {
  const error = useRouteError();

  let title = 'An error occured!';
  let message = 'Unknown error occured!';

  if (error.status === 500) {
    message = error.data.message;
  }

  if (error.status === 404) {
    title = 'Not Found';
    message = 'Cannot found the resource';
  }

  // console.log(props);
  return (
    <>
      <PageContent title={title}>
        <p>{message}</p> <br />
        {error.status && <p>Status code: {error.status}</p>}
        {error.toString()}
      </PageContent>
    </>
  );
}

export default ErrorLayout;
