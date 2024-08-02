import axios from "axios";

const API_URL = "http://localhost:8080/api/games";

export const getGames = () => axios.get(API_URL);
