import logo from "./logo.svg";
import "./App.css";

import { Fragment, useState } from "react";
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
import Game from "./Admin/pages/Manage/GameImage/Game";
import GroupComponent from "./Shared/components/pages/group/GroupComponent";
import BlogComponent from "./Shared/components/pages/group/BlogComponent";
import ContactComponent from "./Shared/components/pages/contact/ContactComponent";
function App() {
  const [isAdmin, setIsAdmin] = useState(false);

  return (
    <BrowserRouter>
      <div className="App" style={{ backgroundColor: "#171615" }}>
        <Fragment>
          {isAdmin === false ? <HeaderComponent /> : ""}
          <Routes>
            {/* Home Component */}
            <Route path="/" element={<HomeComponent />}></Route>
            {/* Category Component */}
            <Route path="/category" element={<CategoryComponent />}></Route>
            {/* Review Component */}
            <Route path="/group" element={<GroupComponent />}></Route>
            {/* Group Component */}
            <Route
              path="/blogs/group/:groupId"
              element={<BlogComponent />}
            ></Route>
            {/* Blog Component */}

            <Route
              path="/commentblog/blog/:id"
              element={<BlogComponent />}
            ></Route>
            <Route path="/contact" element={<ContactComponent />}></Route>
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

            {/* ADMIN */}
            <Route path="/admin/game" element={<Game />} />

            {/* <Route path="/admin/gametypes" element={<Gametypes />} />
          <Route path="/admin/gametypes" element={<Gametypes />} />
          <Route path="/admin/order" element={<Order/>} />
          <Route path="/admin/keycode" element={<Keycode/>} />
          <Route path="/admin/gamerqm" element={<GameSystemRequirement/>} />
          <Route path="/admin/rankaccount" element={<RankAccount/>} />
          <Route path="/admin/chart" element={<Chart2/>} />
          <Route path="/admin/chartdetail" element={<ChartDetail/>}/>
          <Route path="/admin/group" element={<Group/>} />
          <Route path="/admin/widget" element={<Widgets />} /> */}
          </Routes>
          {/* {isAdmin === false ? <FooterComponent /> : ""} */}
          <FooterComponent></FooterComponent>
        </Fragment>
      </div>
    </BrowserRouter>
  );
}

export default App;
