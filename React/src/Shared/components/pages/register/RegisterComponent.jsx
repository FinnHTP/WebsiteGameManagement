import React, { useState } from "react";
import "../../../../assets/css/Register.css";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";

const RegisterComponent = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const navigator = useNavigate();

  const handleUsername = (e) => setUsername(e.target.value);
  const handlePassword = (e) => setPassword(e.target.value);
  const handleEmail = (e) => setEmail(e.target.value);

  const handleRegister = (e) => {
    e.preventDefault();

    const registerData = {
      username: username,
      password: password,
      email: email,
    };

    fetch("http://localhost:8080/api/v1/auth/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(registerData),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Register failed");
        }
        return response.json();
      })
      .then((data) => {
        const token = data.token;
        localStorage.setItem("accesstoken", token);
        const decodedToken = jwtDecode(token);
        console.log("Register successful, token stored:", token);
        console.log("Decoded token:", decodedToken);
        navigator("/profile"); // Chuyển hướng đến trang hồ sơ sau khi đăng ký thành công
      })
      .catch((error) => {
        console.error("Register error:", error);
      });
  };

  const handleRedirectLogin = () => navigator("/login");

  return (
    <div>
      <div className="form-login">
        <div className="row">
          <div className="col-lg-2"></div>
          <div className="col-lg-8">
            <div className="row">
              <div className="col-lg-7 mt-2 mb-2">
                <div className="panel-login">
                  <img
                    src="img/logo-login.jpg"
                    alt=""
                    width={500}
                    height={500}
                  />
                </div>
              </div>
              <div className="col-lg-5 form-input mt-2 mb-2 ">
                <div className="form">
                  <h5 className="pt-5 pe-5">
                    <span className="h5-register">Register</span> /{" "}
                    <span className="h5-login" onClick={handleRedirectLogin}>
                      Login
                    </span>
                  </h5>
                  <form onSubmit={handleRegister}>
                    <div className="form-control pe-5">
                      <label htmlFor="username">Username</label>
                      <input
                        type="text"
                        placeholder="Username"
                        id="username"
                        value={username}
                        onChange={handleUsername}
                      />
                    </div>
                    <div className="form-control pe-5">
                      <label htmlFor="password">Password</label>
                      <input
                        type="password"
                        placeholder="Password"
                        id="password"
                        value={password}
                        onChange={handlePassword}
                      />
                    </div>
                    <div className="form-control pe-5">
                      <label htmlFor="email">Email</label>
                      <input
                        type="email"
                        placeholder="Email"
                        id="email"
                        value={email}
                        onChange={handleEmail}
                      />
                    </div>
                    <div className="d-flex">
                      <button type="submit" className="btn btn-warning">
                        Register
                      </button>
                      <a href="#!">
                        <img src="img/icons/google.png" alt="" width={32} />
                      </a>
                      <a href="#!">
                        <img src="img/icons/facebook.png" alt="" width={32} />
                      </a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div className="col-lg-2"></div>
        </div>
      </div>
    </div>
  );
};

export default RegisterComponent;
