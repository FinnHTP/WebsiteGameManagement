import React, { useState } from "react";
import "../../../../assets/css/Login.css";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import GoogleLoginButton from "./GoogleLoginComponent";

const LoginComponent = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [userInfo, setUserInfo] = useState(null);
  const [errors, setErrors] = useState({
    username: "",
    password: "",
  });

  const navigator = useNavigate();

  const handleRedirectRegister = () => navigator("/register");

  const handleUsername = (e) => setUsername(e.target.value);
  const handlePassword = (e) => setPassword(e.target.value);

  const handleLogin = (e) => {
    e.preventDefault();
    if (validateForm()) {
      const loginData = {
        username: username,
        password: password,
      };

      fetch("http://localhost:8080/api/v1/auth/authenticate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(loginData),
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error("Login failed");
          }
          return response.json();
        })
        .then((data) => {
          const token = data.token;
          localStorage.setItem("accesstoken", token);
          const decodedToken = jwtDecode(token);
          setUserInfo(decodedToken);
          console.log("Login successful, token stored:", token);
          console.log("Decoded token:", decodedToken);
          window.location.href = "/profile";
        })
        .catch((error) => {
          console.error("Login error:", error);
        });
    }
  };

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };

    if (username.trim()) {
      errorsCopy.username = "";
    } else {
      errorsCopy.username = "Username is invalid";
      valid = false;
    }
    if (password.trim()) {
      errorsCopy.password = "";
    } else {
      errorsCopy.password = "Password is invalid";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }

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
                    <span className="h5-login" style={{ color: "#ffa623" }}>
                      Login
                    </span>{" "}
                    /{" "}
                    <span
                      className="h5-register"
                      onClick={handleRedirectRegister}
                      style={{ color: "#83858e" }}
                    >
                      Register
                    </span>
                  </h5>
                  <form>
                    <div className="form-control pe-5">
                      <label htmlFor="username">Username</label>
                      <span>
                        {errors.username && (
                          <div className="invalid-feedback">
                            {errors.username}
                          </div>
                        )}
                      </span>
                      <input
                        type="text"
                        placeholder="Username"
                        id="username"
                        value={username}
                        className={`form-control ${
                          errors.username ? "is-invalid" : ""
                        }`}
                        onChange={handleUsername}
                        style={{ color: "white" }}
                      />
                    </div>
                    <div className="form-control pe-5">
                      <label htmlFor="password">Password</label>
                      <input
                        type="password"
                        placeholder="Password"
                        id="password"
                        value={password}
                        className={`form-control ${
                          errors.password ? "is-invalid" : ""
                        }`}
                        onChange={handlePassword}
                        style={{ color: "white" }}
                      />
                    </div>
                    <div
                      style={{
                        marginTop: "10px",
                        marginBottom: "10px",
                      }}
                    >
                      <GoogleLoginButton></GoogleLoginButton>
                    </div>
                    <div>
                      <button
                        type="submit"
                        onClick={handleLogin}
                        className="btn btn-warning"
                      >
                        Login
                      </button>
                    </div>
                    <p className="forgot-pass">
                      <a href="">Forgot Your Password?</a>
                    </p>
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

export default LoginComponent;
