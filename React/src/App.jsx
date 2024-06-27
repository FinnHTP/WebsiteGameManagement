import logo from "./logo.svg";
import "./App.css";

import { Fragment } from "react";
import "owl.carousel/dist/assets/owl.carousel.css";
import "owl.carousel/dist/assets/owl.theme.default.css";
import "jquery";
import "owl.carousel";
import HeaderComponent from "./Shared/components/HeaderComponent";
import FooterComponent from "./Shared/components/FooterComponent";
import LoginComponent from "./Shared/components/pages/login/LoginComponent";
import RegisterComponent from "./Shared/components/pages/register/RegisterComponent";
import CategoryComponent from "./Shared/components/pages/categories/CategoryComponent";
import ReviewComponent from "./Shared/components/pages/review/ReviewComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomeComponent from "./Shared/components/pages/home/HomeComponent";
import ProfileComponent from "./Shared/components/pages/profile/ProfileComponent";
import ForgotComponent from "./Shared/components/pages/forgotpass/ForgotComponent";
import ChangePassComponent from "./Shared/components/pages/changepass/ChangePassComponent";
import GameDetailComponent from "./Shared/components/pages/comments/GameDetailComponent";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Fragment>
          <HeaderComponent />
          <Routes>
            {/* Home Component */}
            <Route path="/" element={<HomeComponent />}></Route>
            {/* Category Component */}
            <Route path="/category" element={<CategoryComponent />}></Route>
            {/* Review Component */}
            <Route path="/review" element={<ReviewComponent />}></Route>
            {/* Login Component */}
            <Route path="/login" element={<LoginComponent />}></Route>
            {/* Register Component */}
            <Route path="/register" element={<RegisterComponent />}></Route>
            {/* Profile Component */}
            <Route path="/profile" element={<ProfileComponent />}></Route>
            <Route path="/profile/*" element={<ProfileComponent />}></Route>
            {/* Forgot Component */}
            <Route path="/forgot" element={<ForgotComponent />}></Route>
            {/* ChangePass Component */}
            <Route path="/changepass" element={<ChangePassComponent />}></Route>
            {/* Comment Component */}
            <Route path="/gamedetail" element={<GameDetailComponent />}></Route>
            <Route
              path="/gamedetail/:id"
              element={<GameDetailComponent />}
            ></Route>
          </Routes>
          <FooterComponent />
        </Fragment>
      </div>
    </BrowserRouter>
  );
}

export default App;
