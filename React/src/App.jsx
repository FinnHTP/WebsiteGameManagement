import React, { Fragment, useState, useEffect } from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import {jwtDecode} from "jwt-decode"; // You might need to install this if you haven't already
import HeaderComponent from "./Shared/components/HeaderComponent";
import FooterComponent from "./Shared/components/FooterComponent";
import LoginComponent from "./Shared/components/pages/login/LoginComponent";
import RegisterComponent from "./Shared/components/pages/register/RegisterComponent";
import CategoryComponent from "./Shared/components/pages/categories/CategoryComponent";
import ReviewComponent from "./Shared/components/pages/review/ReviewComponent";
import HomeComponent from "./Shared/components/pages/home/HomeComponent";
import ProfileComponent from "./Shared/components/pages/profile/ProfileComponent";
import ForgotComponent from "./Shared/components/pages/forgotpass/ForgotComponent";
import ChangePassComponent from "./Shared/components/pages/changepass/ChangePassComponent";
import GameDetailComponent from "./Shared/components/pages/comments/GameDetailComponent";
import Game from "./Admin/pages/Manage/GameImage/Game";
import GroupComponent from "./Shared/components/pages/group/GroupComponent";
import BlogComponent from "./Shared/components/pages/group/BlogComponent";
import ContactComponent from "./Shared/components/pages/contact/ContactComponent";
import NotFoundPage from "./Shared/components/pages/decentralized/NotFoundPage";
import RoleBasedRoute from "./Shared/components/pages/decentralized/RoleBasedRoute";
import UnauthorizedPage from "./Shared/components/pages/decentralized/UnauthorizedPage";

function App() {
  const [isAdmin, setIsAdmin] = useState(false);
  const [userRoles, setUserRoles] = useState([]);
  
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [checkingAuth, setCheckingAuth] = useState(true);

  useEffect(() => {
    checkLogin();
  }, []);

  useEffect(() => {
    console.log('Is Authenticated:', isAuthenticated);
    console.log('User Roles:', userRoles);
  
  }, [isAuthenticated, userRoles]);

  const checkLogin = () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Not logged in yet");
      setIsAuthenticated(false);
    } else {
      try {
        const decodedToken = jwtDecode(token);
        setIsAuthenticated(true);
        setUserRoles(decodedToken.roles[0]);
        console.log('Decoded Token Roles:', decodedToken.roles[0]);
        console.log('User Roles', userRoles )
      } catch (error) {
        console.error("Invalid token", error);
        setIsAuthenticated(false);
      }
    }
    setCheckingAuth(false);
  };

  if (checkingAuth) {
    return <div>Loading...</div>; 
  }

  return (
    <BrowserRouter>
      <div className="App" style={{ backgroundColor: "#171615" }}>
        <Fragment>
          {isAdmin === false ? <HeaderComponent /> : ""}
          <Routes>
            <Route path="/" element={<HomeComponent />} />
            <Route path="/category" element={<CategoryComponent />} />
            <Route path="/group" element={<GroupComponent />} />
            <Route path="/blogs/group/:groupId" element={<BlogComponent />} />
            <Route path="/commentblog/blog/:id" element={<BlogComponent />} />
            <Route path="/contact" element={<ContactComponent />} />
            <Route path="/review" element={<ReviewComponent />} />
            <Route path="/login" element={<LoginComponent />} />
            <Route path="/register" element={<RegisterComponent />} />
            <Route path="/profile" element={<ProfileComponent />} />
            <Route path="/profile/*" element={<ProfileComponent />} />
            <Route path="/forgot" element={<ForgotComponent />} />
            <Route path="/changepass" element={<ChangePassComponent />} />
            <Route path="/gamedetail" element={<GameDetailComponent />} />
            <Route path="/gamedetail/:id" element={<GameDetailComponent />} />
            <Route path="/unauthorized" element={<UnauthorizedPage />} />

            <Route path="/contact" element={<ContactComponent/>} />

            <Route
              path="/admin/*"
              element={
                isAuthenticated ? (
                  <RoleBasedRoute isAuthenticated={isAuthenticated} userRoles={userRoles} allowedRoles={['ADMIN']}>
                    <Game/>
                  </RoleBasedRoute>
                ) : (
                  <Navigate to="/unauthorized" />
                )
              }
            />

            <Route path="*" element={<NotFoundPage />} />
          </Routes>
          <FooterComponent />
        </Fragment>
      </div>
    </BrowserRouter>
  );
}

export default App;
