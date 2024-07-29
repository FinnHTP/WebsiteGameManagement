import React from 'react';
import { Navigate } from 'react-router-dom';

const RoleBasedRoute = ({ children, isAuthenticated, userRoles, allowedRoles }) => {
  if (!isAuthenticated) {
    return <Navigate to="/login" />;
  }
  
  if (!allowedRoles.includes(userRoles)) {
    return <Navigate to="/unauthorized" />; 
  }
  
  return children;
};



export default RoleBasedRoute;
