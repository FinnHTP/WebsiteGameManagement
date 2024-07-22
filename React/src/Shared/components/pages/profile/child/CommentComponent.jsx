import axios from "axios";
import React, { useEffect, useState } from "react";
import OrderDetailModal from "../../../common/OrderDetailModal";
import { useParams } from "react-router-dom";
import { jwtDecode } from "jwt-decode";

const CommentComponent = () => {
  const [currentPage, setCurrentPage] = useState(1);
  const [comments, setComments] = useState([]);
  const [selectedOrder, setSelectedOrder] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const [itemsPerPage] = useState(3); // Số lượng comment trên mỗi trang
  const { id } = useParams();

  // Hàm lấy danh sách tất cả comment từ API
  const listAllComments = async () => {
    const token = localStorage.getItem("accesstoken");
    const decode = jwtDecode(token);
    const accountId = decode.id;

    if (!token) {
      console.error("Token Not Found");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/comment/findByAccount/${accountId}`,
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

      setComments(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Fail to Request", error);
    }
  };

  // Hàm xử lý khi người dùng chuyển đổi trang
  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  // Tính toán phân đoạn của danh sách comments để hiển thị trên trang hiện tại
  const indexOfLastComment = currentPage * itemsPerPage;
  const indexOfFirstComment = indexOfLastComment - itemsPerPage;
  const currentComments = comments.slice(
    indexOfFirstComment,
    indexOfLastComment
  );

  // Hàm đóng modal chi tiết đơn hàng
  const handleCloseModal = () => {
    setSelectedOrder(null);
    setShowModal(false);
  };

  // Hàm hiển thị chi tiết đơn hàng
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
    listAllComments(); // Gọi hàm lấy danh sách comment khi component được render
  }, []);

  return (
    <div>
      <h6 className="h6-infor-user">Comment History</h6>
      <p style={{ marginLeft: "15px" }}>Display History Your Comment</p>
      <div className="search-order d-flex text-center justify-content-left ">
        <label>Comment Number:</label>
        <input type="text" placeholder="Comment Number" />
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
            <th scope="col">Content</th>
            <th scope="col">Date</th>
            <th scope="col">Game</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {currentComments.map((comment, index) => (
            <tr key={comment.id}>
              <th scope="row">{index + 1}</th>
              <td>{comment.content}</td>
              <td>{comment.date}</td>
              <td>{comment.game.name}</td>
              <td>
                <span
                  className="btn btn-warning"
                  onClick={() => showOrderDetail(comment.game.id)}
                >
                  Detail
                </span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <nav className="pagination-nav">
        <ul className="pagination justify-content-center">
          {Array.from(
            { length: Math.ceil(comments.length / itemsPerPage) },
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
                  style={{ fontSize: "1.3rem", cursor: "pointer" }}
                >
                  {index + 1}
                </span>
              </li>
            )
          )}
        </ul>
      </nav>
      {showModal && (
        <OrderDetailModal
          order={selectedOrder}
          handleCloseModal={handleCloseModal}
        />
      )}
    </div>
  );
};

export default CommentComponent;
