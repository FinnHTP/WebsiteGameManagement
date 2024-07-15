import { jwtDecode } from "jwt-decode";
import React, { useEffect, useState } from "react";

const HeaderComponent = () => {
  const [user, setUser] = useState("");
  const [display, setDisplay] = useState("hidden");

  useEffect(() => {
    const token = localStorage.getItem("accesstoken");
    if (token) {
      const decode = jwtDecode(token);
      setUser(decode);
      console.log(user);
    } else {
      return;
    }
  }, []);

  return (
    <header className="header-section">
      <div className="container">
        <a className="site-logo" href="index.html">
          <img src="img/logo.png" alt="" />
        </a>
        <div
          className="user-panel"
          style={{ display: `${user}` == "" ? "inline-block" : "none" }}
        >
          <a href="/login">Login</a> / <a href="/register">Register</a>
        </div>
        <div
          className="user-panel"
          style={{ display: `${user}` != "" ? "inline-block" : "none" }}
        >
          <a href="/profile">{user.email}</a>
        </div>

        <div className="nav-switch">
          <i className="fa fa-bars"></i>
        </div>

        <nav className="main-menu">
          <ul>
            <li>
              <a href="/">Home</a>
            </li>
            <li>
              <a href="/review">Review</a>
            </li>
            <li>
              <a href="/category">Category</a>
            </li>
            <li>
              <a href="/group">Group</a>
            </li>
            <li>
              <a href="/games">Game</a>
            </li>
            <li>
              <a href="#!">Contact</a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default HeaderComponent;
