import axios from "axios";
import React, { useEffect, useRef, useState } from "react";
import OrderDetailModal from "../../../common/OrderDetailModal";
import { jwtDecode } from "jwt-decode";
// import { Modal } from "bootstrap";

const OrderComponent = () => {
  const [currentPage, setCurrentPage] = useState(1);
  const [orders, setOrders] = useState([]);
  const [selectedOrder, setSelectedOrder] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const [itemsPerPage] = useState(3);
  const ListAllOrder = async () => {
    const token = localStorage.getItem("accesstoken");
    const decoded = jwtDecode(token);
    const accountId = decoded.id;
    if (!token) {
      console.log("token not found");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/orders/list/${accountId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
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
  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  // Tính toán phân đoạn của danh sách comments để hiển thị trên trang hiện tại
  const indexOfLastComment = currentPage * itemsPerPage;
  const indexOfFirstComment = indexOfLastComment - itemsPerPage;
  const currentOrders = orders.slice(indexOfFirstComment, indexOfLastComment);
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
          {currentOrders.map((order, index) => (
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
                <div className="row">
                  <div className="col-6">
                  <p>
                    <strong>Price:</strong>{" "}
                    {new Intl.NumberFormat("de-DE").format(selectedOrder.price)}
                    đ
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
                  </div>
                  <div className="col-6">
                  <img src={`/img/recent-game/${selectedOrder.game.image}`} alt="" />
                  <p>
                    <strong>GameType:</strong> {selectedOrder.game.gameType.name}
                  </p>
                  </div>
                </div>
                  
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
      <nav className="pagination-nav" style={{ marginTop: "-13px" }}>
        <ul className="pagination justify-content-center">
          {Array.from(
            { length: Math.ceil(orders.length / itemsPerPage) },
            (_, index) => (
              <li
                key={index}
                className={`page-item ${
                  currentPage === index + 1 ? "active" : ""
                }`}
              >
                <span
                  className="page-link"
                  onClick={() => handlePageChange(index + 1)}
                  style={{ fontSize: "1.3rem" }}
                >
                  {index + 1}
                </span>
              </li>
            )
          )}
        </ul>
      </nav>
      {showModal && <div className="modal-backdrop fade show"></div>}
    </div>
  );
};

export default OrderComponent;
