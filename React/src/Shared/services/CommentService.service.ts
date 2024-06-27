import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/comment";

export const getAllComment = () => axios.get(API_BASE_URL);

export const createComment = (comment) => axios.post(API_BASE_URL + comment);

export const getCommentById = (commentId) =>
  axios.get(API_BASE_URL + "/" + commentId);
