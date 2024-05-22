import { googleLogout } from '@react-oauth/google';
import React, { createContext, useContext, useState, useEffect } from 'react';
import { json, redirect } from 'react-router-dom';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(
    !!localStorage.getItem('isLoggedIn')
  );

  const login = (params) => {
    localStorage.setItem('userDetails', params.userDetails);
    localStorage.setItem('profile', params.profile);
    localStorage.setItem('token', params.token);
    localStorage.setItem('expiration', params.expiration);
    localStorage.setItem('loggedIn', 'true');
    setIsLoggedIn(true);
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('expiration');
    localStorage.removeItem('loggedIn');
    localStorage.removeItem('userDetails');
    localStorage.removeItem('profile');
    setIsLoggedIn(false);

    try {
      googleLogout();
    } catch (err) {
      throw json({ message: err.toString() });
    }

    return redirect('/ui');
  };

  useEffect(() => {
    setIsLoggedIn(!!localStorage.getItem('isLoggedIn'));
  }, []);

  return (
    <AuthContext.Provider value={{ isLoggedIn, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// Hook to use the AuthContext
export const useAuth = () => useContext(AuthContext);
