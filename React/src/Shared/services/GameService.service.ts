import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/games";

export const listGame = () => axios.get(API_BASE_URL + "/");

export const getGameById = (gameId) => axios.get(API_BASE_URL + "/" + gameId);
