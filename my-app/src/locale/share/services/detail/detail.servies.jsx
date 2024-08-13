import axios from "axios";

const fetchGameById = async (gameId) => {
  //   const token = localStorage.getItem("accesstoken");
  //   if (!token) {
  //     console.error("Không có token được tìm thấy");
  //     return;
  //   }

  try {
    const response = await axios.get(
      `http://localhost:8080/api/games/${gameId}`,
      {
        // headers: {
        //   Authorization: `Bearer ${token}`,
        // },
      }
    );
    const data =
      typeof response.data === "string"
        ? JSON.parse(response.data)
        : response.data;
    console.log("Game data: ", data);
    return data;
  } catch (error) {
    console.error("Fail To Request:", error);
  }
};

const fetchGameSystemRequirements = async (gameId) => {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/gameSystemRequirement/findByGame/${gameId}`,
      {
        // headers: {
        //   Authorization: `Bearer ${token}`,
        // },
      }
    );
    if (Array.isArray(response.data)) {
      console.log("System Requirements:", response.data);
      return response.data;
    } else {
      console.error("Unexpected data format:", response.data);
      return [];
    }
  } catch (error) {
    console.error("Failed to fetch system requirements:", error);
    return [];
  }
};

export { fetchGameById, fetchGameSystemRequirements };
