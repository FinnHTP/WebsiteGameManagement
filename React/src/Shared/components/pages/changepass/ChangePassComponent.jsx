import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../../../../assets/css/Login.css";

const ChangePassComponent = () => {
  const [email, setEmail] = useState("");
  const [otp, setOtp] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [errors, setErrors] = useState({
    email: "",
    otp: "",
    newPassword: "",
  });

  const navigator = useNavigate();

  const handleEmail = (e) => setEmail(e.target.value);
  const handleOtp = (e) => setOtp(e.target.value);
  const handleNewPassword = (e) => setNewPassword(e.target.value);

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent form submission

    // Validate inputs
    let valid = true;
    const newErrors = {
      email: "",
      otp: "",
      newPassword: "",
    };

    if (email === "") {
      valid = false;
      newErrors.email = "Email is required";
    }

    if (otp === "") {
      valid = false;
      newErrors.otp = "OTP is required";
    }

    if (newPassword === "") {
      valid = false;
      newErrors.newPassword = "New Password is required";
    }

    setErrors(newErrors);

    if (valid) {
      // If all inputs are valid, proceed with API call or other actions
      // Example: Fetching API to change password
      fetch(
        "http://localhost:8080/api/password/reset?email=" +
          email +
          "&otp=" +
          otp +
          "&newPassword=" +
          newPassword,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            email,
            otp,
            newPassword,
          }),
        }
      )
        .then((response) => {
          if (!response.ok) {
            throw new Error("Change password failed");
          }
          // Handle success response if needed
          navigator("/login"); // Redirect to login page after password change
        })
        .catch((error) => {
          console.error(error);
          // Handle error, maybe update state.errors.email with relevant message
        });
    }
  };

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
                  <h5 className="pt-5 pe-5">Change Password</h5>
                  <form>
                    <div className="form-control pe-5">
                      <label htmlFor="email">Email</label>
                      <span>
                        {errors.email && (
                          <div className="invalid-feedback">{errors.email}</div>
                        )}
                      </span>
                      <input
                        type="email"
                        placeholder="Email"
                        id="email"
                        value={email}
                        className={`form-control ${
                          errors.email ? "is-invalid" : ""
                        }`}
                        onChange={handleEmail}
                        style={{ color: "white" }}
                      />
                    </div>

                    <div className="form-control pe-5">
                      <label htmlFor="otp">OTP</label>
                      <span>
                        {errors.otp && (
                          <div className="invalid-feedback">{errors.otp}</div>
                        )}
                      </span>
                      <input
                        type="text"
                        placeholder="OTP"
                        id="otp"
                        value={otp}
                        className={`form-control ${
                          errors.otp ? "is-invalid" : ""
                        }`}
                        onChange={handleOtp}
                        style={{ color: "white" }}
                      />
                    </div>

                    <div className="form-control pe-5">
                      <label
                        htmlFor="newPassword"
                        style={{ marginLeft: "20px" }}
                      >
                        NewPass
                      </label>
                      <span>
                        {errors.newPassword && (
                          <div className="invalid-feedback">
                            {errors.newPassword}
                          </div>
                        )}
                      </span>
                      <input
                        type="password"
                        placeholder="New Password"
                        id="newPassword"
                        value={newPassword}
                        className={`form-control ${
                          errors.newPassword ? "is-invalid" : ""
                        }`}
                        onChange={handleNewPassword}
                        style={{ color: "white" }}
                      />
                    </div>

                    <div className="d-flex">
                      <button
                        type="submit"
                        onClick={handleSubmit}
                        className="btn btn-warning"
                      >
                        Confirm
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

export default ChangePassComponent;
