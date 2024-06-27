import axios from "axios";
import React, { useEffect, useRef, useState } from "react";
import OrderDetailModal from "../../../common/OrderDetailModal";
import { useParams } from "react-router-dom";
// import { Modal } from "bootstrap";

const CommentComponent = () => {
  const [visibleComments, setVisibleComments] = useState(5);
  const [comments, setComments] = useState([]);
  const [selectedOrder, setSelectedOrder] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const { id } = useParams();
  const listAllComments = async () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Token Not Found");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/comment/findByAccount/3`,
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
  const showMoreComments = () => {
    setVisibleComments(visibleComments + 5); // Hiển thị thêm 5 comment
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
    listAllComments();
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
            <th scope="col">GameId</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {comments.slice(0, visibleComments).map((comment, index) => (
            <tr key={comment.id}>
              <th scope="row">{index + 1}</th>
              <td>{comment.content}</td>
              <td>{comment.date}</td>
              <td>{comment.game.id}</td>
              <td>
                <span className="btn btn-warning">Detail</span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CommentComponent;
