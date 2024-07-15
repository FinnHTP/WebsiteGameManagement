import axios from "axios";
import { jwtDecode } from "jwt-decode";
import React, { useEffect, useState } from "react";

const AccountComponent = () => {
  const [user, setUser] = useState({});
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [sdt, setSdt] = useState("");
  const [avatar, setAvatar] = useState("");
  const [account, setAccount] = useState({});
  const [selectedOrder, setSelectedOrder] = useState(null);
  const [showModal, setShowModal] = useState(false);

  const findUserById = async () => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.log("Token not found!");
      return;
    }
    try {
      const decoded = jwtDecode(token);
      const accountId = decoded.id;
      const response = await axios.get(
        `http://localhost:8080/api/user/${accountId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      const data =
        typeof response.data === "string"
          ? JSON.parse(response.data)
          : response.data;
      setUser(data);
      console.log(user);
    } catch (error) {
      console.error("Invalid token", error);
    }
  };

  const recharge = async (Money) => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.log("Token not found!");
      return;
    }
    try {
      const decoded = jwtDecode(token);
      const accountId = decoded.id;
      const amountAccount = Money;
      const paymentValues = {
        amount: JSON.stringify(amountAccount),
        accountId: accountId,
      };
      const queryString = new URLSearchParams(paymentValues).toString();
      console.log(queryString);
      const response = await axios.post(
        `http://localhost:8080/api/payment/create?${queryString}`,

        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      if (response.status === 200) {
        const responseUrl = response.data.data;
        window.location.href = responseUrl;
        console.log(responseUrl);
        const resultPayment = await axios.post(
          `http://localhost:8080/api/payment/save-payment?${queryString}`,

          {
            headers: {
              Authorization: `Bearer ${token}`,
            },
          }
        );
      }
    } catch (error) {
      console.error("Invalid token", error);
    }
  };

  const ButtonOpenModal = () => {
    setShowModal(true);
  };
  const updateAccount = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.log("Token not found!");
      return;
    }
    try {
      const decoded = jwtDecode(token);
      const accountId = decoded.id;
      const user = { avatar, firstName, lastName, sdt };
      const response = await axios.put(
        `http://localhost:8080/api/user/${accountId}`,
        user,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      const data =
        typeof response.data === "string"
          ? JSON.parse(response.data)
          : response.data;
      setUser(data);
      console.log(user);
    } catch (error) {
      console.error("Invalid token", error);
    }
  };

  const findAccountById = async () => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.log("Token not found!");
      return;
    }
    try {
      const decoded = jwtDecode(token);
      const accountId = decoded.id;
      const response = await axios.get(
        `http://localhost:8080/api/account/${accountId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      const data =
        typeof response.data === "string"
          ? JSON.parse(response.data)
          : response.data;
      setAccount(data);
      console.log(account);
    } catch (error) {
      console.error("Invalid token", error);
    }
  };

  const handleCloseModal = () => {
    setSelectedOrder(null);
    setShowModal(false);
  };

  const handleFirstName = (e) => setFirstName(e.target.value);
  const handleLastName = (e) => setLastName(e.target.value);

  useEffect(() => {
    findAccountById();
    findUserById();
  }, []);

  if (!account) {
    return <div>No user information available.</div>;
  }
  return (
    <div>
      <h6 className="h6-infor-user">User Information</h6>
      <div className="row infor-user-span-p">
        <div className="col-3">
          <span className="span-infor-user">Username:</span> <br />
          <p className="p-infor-user">{account.username}</p>
          <span className="span-infor-user">Balance</span>
          <p className="p-infor-user">
            {new Intl.NumberFormat("de-DE").format(account.accountBalance)}đ
            <a href="#" onClick={ButtonOpenModal}>
              <strong
                style={{
                  marginLeft: "3px",
                  fontSize: "11px",
                  border: "1px solid #ccc",
                  padding: "3px",
                  borderRadius: "5px",
                }}
              >
                Recharge
              </strong>
            </a>
          </p>
        </div>
        <div className="col-3">
          <span className="span-infor-user">Email:</span> <br />
          <p className="p-infor-user">{account.email}</p>
          <span className="span-infor-user">Accumulated</span>
          <p className="p-infor-user">0</p>
        </div>
        <div className="col-3">
          <span className="span-infor-user">FirstName:</span> <br />
          <p className="p-infor-user">{user.firstname || "Update your info"}</p>
          <span className="span-infor-user">RankType</span>
          <p className="p-infor-user">{account.rankType || "Bronze"}</p>
        </div>
        <div className="col-3">
          <span className="span-infor-user">LastName:</span> <br />
          <p className="p-infor-user">{user.lastname || "Update your info"}</p>
        </div>
      </div>
      <div className="row infor-image">
        <div className="col-6 infor-image-item">
          <img
            src={
              user.avatar ||
              "https://cdn-icons-png.flaticon.com/128/149/149071.png"
            }
            alt="User Avatar"
            width={60}
          />
          <button className="btn update-image">Update Avatar</button>
        </div>
        <div className="col-6 data-image">
          <p>Vui lòng chọn ảnh nhỏ hơn 5MB, Chọn ảnh phù hợp, không phản cảm</p>
        </div>
      </div>
      <div className="personal-infor">
        <h6 className="h6-personal">Personal</h6>
        <div className="mt-3">
          <span className="span-infor-user">FirstName:</span> <br /> <br />
          <input
            type="text"
            className="input-personal"
            placeholder="First Name"
            id={firstName}
            value={firstName}
            onChange={handleFirstName}
          />{" "}
          <br /> <br />
          <span className="span-infor-user mt-3">LastName</span> <br /> <br />
          <input
            type="text"
            className="input-personal"
            placeholder="Last Name"
            id={lastName}
            value={lastName}
            onChange={handleLastName}
          />
        </div>
        <button
          className="btn btn-confirm"
          type="submit"
          onClick={updateAccount}
        >
          Confirm
        </button>
      </div>
      <div
        className={`modal fade ${showModal ? "show" : ""}`}
        style={{ display: showModal ? "block" : "none" }}
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Recharge</h5>
              <button
                type="button"
                className="btn-close"
                aria-label="Close"
                onClick={handleCloseModal}
              ></button>
            </div>
            <div className="modal-body">
              {
                <>
                  <div>
                    <h6>Credit Boosters</h6>
                  </div>
                  <div>
                    <div
                      className="btn btn-warning"
                      style={{
                        marginRight: "15px",
                        marginTop: "10px",
                        fontSize: "1.5rem",
                        width: "130px",
                      }}
                      onClick={() => recharge(75000)}
                    >
                      75000 đ
                    </div>
                  </div>
                  <div>
                    <div
                      className="btn btn-warning"
                      style={{
                        marginRight: "15px",
                        marginTop: "10px",
                        fontSize: "1.5rem",
                        width: "130px",
                      }}
                      onClick={() => recharge(150000)}
                    >
                      150.000 đ
                    </div>
                  </div>
                  <div>
                    <div
                      className="btn btn-warning"
                      style={{
                        marginRight: "15px",
                        marginTop: "10px",
                        fontSize: "1.5rem",
                        width: "130px",
                      }}
                      onClick={() => recharge(225000)}
                    >
                      225.000 đ
                    </div>
                  </div>
                  <div>
                    <div
                      className="btn btn-warning"
                      style={{
                        marginRight: "15px",
                        marginTop: "10px",
                        fontSize: "1.5rem",
                        width: "130px",
                      }}
                      onClick={() => recharge(300000)}
                    >
                      300.000 đ
                    </div>
                  </div>
                  <p>
                    <strong className="text-danger">Notes:</strong> Very
                    understanding because you can only top up in packages with a
                    fixed price. Sorry for the inconvenience
                  </p>
                </>
              }
            </div>
            <div className="modal-footer">
              <button
                className="btn btn-warning"
                variant="secondary"
                onClick={handleCloseModal}
              >
                Close
              </button>
            </div>
          </div>
        </div>
      </div>
      {showModal && <div className="modal-backdrop fade show"></div>}
    </div>
  );
};

export default AccountComponent;
