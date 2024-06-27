import axios from "axios";
import React, { useEffect, useRef, useState } from "react";
import OrderDetailModal from "../../../common/OrderDetailModal";
// import { Modal } from "bootstrap";

const TransactionComponent = () => {
  const [orders, setOrders] = useState([]);
  const [selectedOrder, setSelectedOrder] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const ListAllOrder = async () => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.log("token not found");
      return;
    }

    try {
      const response = await axios.get("http://localhost:8080/api/orders", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      const data =
        typeof response.data === String
          ? JSON.parse(response.data)
          : response.data;
      console.log(data);
      setOrders(data);
    } catch (error) {
      console.error(error);
    }
  };
  const handleCloseModal = () => {
    setSelectedOrder(null);
    setShowModal(false);
  };
  const showOrderDetail = async (orderId) => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.log("token not found");
      return;
    }
    try {
      const response = await axios.get(
        `http://localhost:8080/api/ordersdetail/${orderId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      const orderDetail = response.data;
      setSelectedOrder(orderDetail);
      setShowModal(true);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    ListAllOrder();
  }, []);
  return (
    <div>
      <h6 className="h6-infor-user">Order History</h6>
      <p style={{ marginLeft: "15px" }}>
        Display information about the games you have purchased.
      </p>
      <div className="search-order d-flex text-center justify-content-between ">
        <label>Order Number:</label>
        <input type="text" placeholder="Order Number" />
        <label>Amount From:</label>
        <input type="text" placeholder="Amount From" />
        <label>Amount To:</label>
        <input type="text" placeholder="Amount To" />
        <label>From Date:</label>
        <input type="date" title="From Date" />
        <label>To Date:</label>
        <input type="date" title="To Date" />
        <button className="btn btn-warning">Search</button>
      </div>
      <table className="tbl-order table mt-5">
        <thead>
          <tr>
            <th scope="col">Index</th>
            <th scope="col">Date</th>
            <th scope="col">Account</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order, index) => (
            <tr key={order.id}>
              <th scope="row">{index + 1}</th>
              <td>{order.date}</td>
              <td>{order.account.username}</td>
              <td>
                {" "}
                <span
                  onClick={() => showOrderDetail(order.id)}
                  className="btn btn-warning"
                >
                  Detail
                </span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div
        className={`modal fade ${showModal ? "show" : ""}`}
        style={{ display: showModal ? "block" : "none" }}
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Order Detail</h5>
              <button
                type="button"
                className="btn-close"
                aria-label="Close"
                onClick={handleCloseModal}
              ></button>
            </div>
            <div className="modal-body">
              {selectedOrder && (
                <>
                  <p>
                    <strong>ID:</strong> {selectedOrder.id}
                  </p>
                  <p>
                    <strong>Price:</strong> {selectedOrder.price}
                  </p>
                  <p>
                    <strong>Game:</strong> {selectedOrder.game.name}
                  </p>
                  <p>
                    <strong>Keycode:</strong> {selectedOrder.keycode.keycode}
                  </p>
                  <p>
                    <strong>Order:</strong> {selectedOrder.order.id}
                  </p>
                </>
              )}
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

export default TransactionComponent;
