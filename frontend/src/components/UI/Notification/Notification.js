import React, { useState, useEffect } from 'react';

function NotificationComponent({ message }) {
  const [isVisible, setIsVisible] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsVisible(false);
    }, 5000); // 5000 milliseconds = 5 seconds

    return () => clearTimeout(timer);
  }, []); // Run once on mount

  return <div style={{ display: isVisible ? 'block' : 'none' }}>{message}</div>;
}

export default NotificationComponent;
