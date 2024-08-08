import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { fetchGameById } from "../../services/detail/detail.servies";
import { format } from "date-fns";

const Game = () => {
  const [game, setGame] = useState({});
  const { id } = useParams();

  const getGameById = async (gameId) => {
    try {
      const data = await fetchGameById(gameId);
      if (typeof data === "object" && data !== null) {
        setGame(data);
      } else {
        console.error("Dữ liệu trả về không phải là đối tượng:", data);
      }
    } catch (error) {
      console.error("Lỗi khi lấy dữ liệu:", error);
    }
  };

  const formatDate = (dateString) => {
    const date = new Date(dateString);
    if (isNaN(date.getTime())) {
      // Nếu giá trị ngày tháng không hợp lệ, trả về giá trị mặc định
      return "Ngày không hợp lệ";
    }
    return format(date, "dd/MM/yyyy HH:mm:ss");
  };

  useEffect(() => {
    if (id) {
      getGameById(id);
    }
  }, [id]);

  return (
    <div>
      <div className="grid grid-cols-3">
        <div>
          <img src={`/image/games/${game.image}`} alt="Image Broken" />
        </div>
        <div className="bg-customBgFreeGames h-auto p-4">
          <div className="text-customTextSales">Name Game</div>
          <h1 className="text-white text-xl">
            {game.name || "Loading..."}
          </h1>{" "}
          <div className="text-customTextSales mt-4">Price Game</div>
          <h1 className="text-white text-xl">
            {new Intl.NumberFormat("de-DE").format(game.priceGame) ||
              "Loading..."}
            đ{" "}
          </h1>{" "}
          <div className="text-customTextSales mt-4">Release Date</div>
          <h1 className="text-white text-xl">
            {formatDate(game.releaseDate)}{" "}
          </h1>{" "}
          <div className="text-customTextSales mt-4">Version</div>
          <h1 className="text-white text-xl">
            {game.version || "Loading..."}{" "}
          </h1>{" "}
          <div className="text-customTextSales mt-4">Goods</div>
          {game.status ? (
            <h1 className="text-emerald-500 text-xl">Stocking</h1>
          ) : (
            <h1 className="text-red-600 text-xl">Out of Stock</h1>
          )}
          <div className="bg-customBgBrowse cursor-pointer text-white py-2 px-4 rounded hover:bg-gray-500 inline-block mt-5">
            Buy Game
          </div>
        </div>
      </div>
    </div>
  );
};

export default Game;
