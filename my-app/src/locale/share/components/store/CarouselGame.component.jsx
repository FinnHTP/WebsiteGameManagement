import React, { useState } from "react";
import axios from 'axios';
const CarouselGame = () => {
  const [currentIndex, setCurrentIndex] = useState(0);
  const [games, setGames] = useState([]);
  const images = [
    "/image/top-bg-game/honkaistar.jpg",
    "/image/top-bg-game/apex.jpg",
    "/image/top-bg-game/minecraft.jpg",
    "/image/top-bg-game/apex.jpg",
    "/image/top-bg-game/minecraft.jpg",
  ];

  const prevSlide = () => {
    setCurrentIndex((prevIndex) =>
      prevIndex === 0 ? images.length - 1 : prevIndex - 1
    );
  };

  const nextSlide = () => {
    setCurrentIndex((prevIndex) =>
      prevIndex === images.length - 1 ? 0 : prevIndex + 1
    );
  };

  const handleThumbnailClick = (index) => {
    setCurrentIndex(index);
  };


  const ListAllGames = async () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/games/get8Game`,
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

      console.log("Dữ liệu nhận được từ API:", data);

      setGames(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Lỗi khi gửi yêu cầu:", error);
    }
  };





  return (
    <div className="flex">
      <div className="flex-1 relative">
        <img
          src={images[currentIndex]}
          alt={`Slide ${currentIndex + 1}`}
          className="w-full h-auto object-cover rounded-lg"
        />
        <button
          onClick={prevSlide}
          className="absolute top-1/2 left-0 transform -translate-y-1/2 bg-gray-800 text-white p-2 rounded-full"
        >
          &lt;
        </button>
        <button
          onClick={nextSlide}
          className="absolute top-1/2 right-0 transform -translate-y-1/2 bg-gray-800 text-white p-2 rounded-full"
        >
          &gt;
        </button>
      </div>

      <div className="flex flex-col justify-center ml-4 space-y-4">
        {images.map((image, index) => (
          <button
            key={index}
            onClick={() => handleThumbnailClick(index)}
            className={`flex items-center p-2 cursor-pointer rounded-lg ${
              index === currentIndex ? "bg-gray-600" : "bg-gray-700"
            }`}
          >
            <img
              src={image}
              alt={`Thumbnail ${index + 1}`}
              className={`w-24 h-16 object-cover rounded-lg border-2 ${
                index === currentIndex ? "border-blue-500" : "border-gray-300"
              }`}
            />
          </button>
        ))}
      </div>
    </div>
  );
};

export default CarouselGame;
