import { jwtDecode } from "jwt-decode";
import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../../assets/css/Header.css";
import { imageOverlay } from "leaflet";
const HeaderComponent = () => {
  const [user, setUser] = useState("");
  // const getUserById = () => {
  //   const token = localStorage.getItem
  // }
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
    <div>
      <nav className="header">
        <ul>
          <li>
            <img src="img/icons/steam.png" alt="" width={70} />
          </li>
          <li>
            <a href="/">Store</a>
          </li>
          <li>
            <a href="">Category</a>
          </li>
          <li>
            <a href="">Forum</a>
          </li>
          <li>
            <a href="">Contact</a>
          </li>

          <li>
            <input type="text" />{" "}
            <span>
              <img
                src="img/icons/search.png"
                alt=""
                style={{
                  width: "30px",
                  marginLeft: "-37px",
                  marginBottom: "6px",
                }}
              />
            </span>
          </li>
          <li>
            {!user ? (
              <a href="/login">Login/Register</a>
            ) : (
              <a href="/profile">
                <img
                  src="https://cdn-icons-png.flaticon.com/128/149/149071.png"
                  alt=""
                  width={52}
                  height={52}
                />
              </a>
            )}
          </li>
        </ul>
      </nav>
    </div>

    // <nav className="navbar navbar-expand-lg bg-body-tertiary">
    //   <div className="container">
    //     <a className="site-logo" href="index.html">
    //       <img src="img/logo.png" alt="" />
    //     </a>
    //     <div
    //       className="user-panel"
    //       style={{ display: `${user}` == "" ? "inline-block" : "none" }}
    //     >
    //       <a href="/login">Login</a> / <a href="/register">Register</a>
    //     </div>
    //     <div
    //       className="user-panel"
    //       style={{ display: `${user}` != "" ? "inline-block" : "none" }}
    //     >
    //       <a href="/profile">{user.email}</a>
    //     </div>

    //     <div className="nav-switch">
    //       <i className="fa fa-bars"></i>
    //     </div>

    //     <nav className="main-menu">
    //       <ul>
    //         <li>
    //           <a href="/">Home</a>
    //         </li>
    //         <li>
    //           <a href="/review">Review</a>
    //         </li>
    //         <li>
    //           <a href="/category">Category</a>
    //         </li>
    //         <li>
    //           <a href="/group">Group</a>
    //         </li>
    //         <li>
    //           <a href="/games">Game</a>
    //         </li>
    //         <li>
    //           <a href="/contact">Contact</a>
    //         </li>
    //       </ul>
    //     </nav>
    //   </div>
    // </nav>
  );
};

export default HeaderComponent;
