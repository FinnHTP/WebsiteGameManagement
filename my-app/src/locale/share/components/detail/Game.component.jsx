import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
  fetchGameById,
  fetchGameSystemRequirements,
} from "../../services/detail/detail.servies";
import { format } from "date-fns";
import GameDescription from "./GameDescription.component";
import SystemRequirements from "./GameSystemRequirement.component";
import GameTypeButton from "./GameType.component";
import CommentSection from "./GameComment.component";

const Game = () => {
  const [game, setGame] = useState({});
  const [systemRequirements, setSystemRequirements] = useState([]);
  const [comments, setComments] = useState([]);
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

  const getGameSystemRequirements = async (gameId) => {
    try {
      const data = await fetchGameSystemRequirements(gameId);
      if (Array.isArray(data) && data.length > 0) {
        setSystemRequirements(data);
      } else {
        console.error("No system requirements found:", data);
      }
    } catch (error) {
      console.error("Error fetching system requirements:", error);
    }
  };

  const formatDate = (dateString) => {
    const date = new Date(dateString);
    if (isNaN(date.getTime())) {
      return "Ngày không hợp lệ";
    }
    return format(date, "dd/MM/yyyy HH:mm:ss");
  };

  const handleGameTypeClick = async (gameType) => {
    try {
      console.log(`Fetch games of type: ${gameType.name}`);
    } catch (error) {
      console.error("Error fetching games by type:", error);
    }
  };

  const handleAddComment = (newComment) => {
    setComments([...comments, newComment]);
  };

  useEffect(() => {
    if (id) {
      getGameById(id);
      getGameSystemRequirements(id);
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

      {/* Game Detail */}
      <div className="flex bg-customBgFreeGames justify-center px-2 mt-12 mb-12">
        <div className="game-detail-container text-white mt-6 px-4 md:px-8">
          <div>
            <h3 className="mb-4 text-xl">Description</h3>
            <GameDescription description={game.description} />
          </div>

          <div className="mt-6">
            <h3 className="mt-6 mb-4 text-xl">Genres</h3>
            {game.gameType ? (
              <GameTypeButton
                gameType={game.gameType}
                onClick={handleGameTypeClick}
              />
            ) : (
              <p>Not available</p>
            )}
          </div>

          <div className="mt-6">
            <h3 className="mt-6 mb-4 text-xl">Rating</h3>
            <p>("Put some rating here...")</p>
          </div>

          <div className="mt-6">
            <h3 className="mt-6 mb-4 text-xl">System Requirements</h3>
            <SystemRequirements requirements={systemRequirements} />
          </div>
        </div>
      </div>

      {/* Comment */}
      <CommentSection comments={comments} onAddComment={handleAddComment} />
    </div>
  );
};

export default Game;
