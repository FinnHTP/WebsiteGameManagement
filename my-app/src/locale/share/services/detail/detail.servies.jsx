import axios from "axios";

export const fetchGameById = async (gameId) => {
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
    console.log(data);
    return data;
  } catch (error) {
    console.error("Fail To Request:", error);
  }
};
