import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../../../../assets/css/Login.css";

const ForgotComponent = () => {
  const [email, setEmail] = useState("");
  const [errors, setErrors] = useState({
    email: "",
  });

  const [emailSent, setEmailSent] = useState(false);

  const navigator = useNavigate();

  const handleEmail = (e) => setEmail(e.target.value);
  const handleForgot = (e) => {
    e.preventDefault(); // Prevent form submission
    fetch("http://localhost:8080/api/password/forgot?email=" + email, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("SendMail failed");
        }
        setEmailSent(true);
        window.href.location = "/changepass";
        // Handle success response if needed
      })
      .catch((error) => {
        console.error(error);
        // Handle error, maybe update state.errors.email with relevant message
      });
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
                  <h5 className="pt-5 pe-5">Forgot Pass</h5>
                  <form>
                    <div className="form-control pe-5">
                      <label htmlFor="username">Username</label>
                      <span>
                        {errors.email && (
                          <div className="invalid-feedback">{errors.email}</div>
                        )}
                      </span>
                      <input
                        type="text"
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

                    <div className="d-flex">
                      <button
                        type="submit"
                        onClick={handleForgot}
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

export default ForgotComponent;
