import React, { useEffect, useState } from "react";
import { getAllGames } from "../../services/category/category.services";

const Game = () => {
  const [games, setGames] = useState([]);
  const findAllGames = async () => {
    // const token = localStorage.getItem("accesstoken");
    try {
      const data = await getAllGames();
      if (Array.isArray(data)) {
        setGames(data);
      } else {
        console.error("Dữ liệu không phải là mảng:", data);
      }
    } catch (error) {
      console.error("Lỗi khi lấy dữ liệu:", error);
    }
  };
  const getDiscount = (coupon, price) => {
    const discount = price - (price * coupon) / 100;
    return discount;
  };
  useEffect(() => {
    findAllGames();
  }, []);
  return (
    <div>
      <div className="grid grid-cols-4 gap-4">
        {games.map((game) => (
          <div
            key={game.id}
            className="max-w-sm rounded overflow-hidden shadow-lg "
          >
            <img
              className="w-full"
              src={`image/games/${game.image}`}
              alt={game.image}
            />
            <div className="pt-4">
              <p className="text-customTypeEdition text-sm">Edition</p>
              <div className="font-medium text-sxl text-white mb-2">
                {game.name}
              </div>
            </div>
            <div className="pt-1 pb-2">
              {game.coupon !== null ? (
                <span className="inline-block bg-customCouponBg rounded-full px-2 py-0 text-sm font-semibold text-gray-700 mr-2 mb-2">
                  -{game.coupon.value}%
                </span>
              ) : (
                ""
              )}

              {game.coupon !== null ? (
                <>
                  {" "}
                  <p className="inline-block line-through text-customTextDiscount">
                    {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                  </p>{" "}
                  <p className="inline-block text-customTextPriceGame">
                    {new Intl.NumberFormat("de-DE").format(
                      getDiscount(game.coupon.value, game.priceGame)
                    )}
                    đ{" "}
                  </p>{" "}
                </>
              ) : (
                <p className="inline-block text-customTextPriceGame">
                  {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                </p>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Game;
