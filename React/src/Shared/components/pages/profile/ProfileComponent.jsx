import React, { useEffect, useState } from "react";
import "../../../../assets/css/Profile.css";
import { jwtDecode } from "jwt-decode";
import axios from "axios";
import { Routes, Route, useNavigate } from "react-router-dom";
import AccountComponent from "./child/AccountComponent";
import OrderComponent from "./child/OrderComponent";
import FavoriteComponent from "./child/FavoriteComponent";
import TransactionComponent from "./child/TransactionComponent";
import CommentComponent from "./child/CommentComponent";

const ProfileComponent = () => {
  const navigator = useNavigate();
  const navAccount = () => navigator("account");
  const navOrder = () => navigator("order");
  const navTransaction = () => navigator("transaction");
  const navFavorite = () => navigator("favorite");
  const navComment = () => navigator("comment");
  const handleLogout = () => localStorage.removeItem("accesstoken");
  return (
    <div className="profile">
      <div className="row">
        <div className="col-1"></div>
        <div className="col-11 profile-user">
          <div className="row">
            <div className="col-3 panel-user">
              <ul className="list-group text-left">
                <li className="list-group-item">
                  <img src="img/icons/user.png" alt="" width={32} />
                  <p onClick={navAccount} style={{ marginLeft: "5px" }}>
                    Account
                  </p>
                </li>
                <li className="list-group-item">
                  <img src="img/icons/shopping-bag.png" alt="" width={32} />
                  <p onClick={navOrder} style={{ marginLeft: "5px" }}>
                    Order History
                  </p>
                </li>
                <li className="list-group-item">
                  <img src="img/icons/credit-card.png" alt="" width={32} />
                  <p onClick={navTransaction} style={{ marginLeft: "5px" }}>
                    Transaction History
                  </p>
                </li>
                {/* <li className="list-group-item">
                  <img src="img/icons/lock.png" alt="" width={25} />
                  <a href="" style={{ marginLeft: "5px" }}>
                    Security
                  </a>
                </li> */}
                <li className="list-group-item">
                  <img src="img/icons/heart.png" alt="" width={32} />
                  <p onClick={navFavorite} style={{ marginLeft: "5px" }}>
                    Favorite
                  </p>
                </li>
                <li className="list-group-item">
                  <img src="img/icons/chat.png" alt="" width={32} />
                  <p onClick={navComment} style={{ marginLeft: "5px" }}>
                    Comment
                  </p>
                </li>
                <li className="list-group-item">
                  <img
                    src="img/icons/logout.png"
                    alt=""
                    width={32}
                    height={32}
                    style={{ marginTop: "10px" }}
                  />
                  <a
                    href="/login"
                    onClick={handleLogout}
                    style={{ marginLeft: "5px" }}
                  >
                    Logout
                  </a>
                </li>
              </ul>
            </div>
            <div className="col-9 infor-user text-left">
              <Routes>
                <Route path="" element={<AccountComponent />}></Route>
                <Route path="account" element={<AccountComponent />}></Route>
                <Route path="order" element={<OrderComponent />}></Route>
                <Route
                  path="transaction"
                  element={<TransactionComponent />}
                ></Route>
                <Route path="favorite" element={<FavoriteComponent />}></Route>
                <Route path="comment" element={<CommentComponent />}></Route>
              </Routes>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProfileComponent;
