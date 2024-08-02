import React, { useState } from "react";

const CarouselGame = () => {
  const [currentIndex, setCurrentIndex] = useState(0);
  const [images, setImages] = useState([
    "/image/top-bg-game/honkaistar.jpg",
    "/image/top-bg-game/honkaistar.jpg",
    "/image/top-bg-game/honkaistar.jpg",
  ]);

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

      <div className="flex flex-col justify-between ml-4">
        {images.map((image, index) => (
          <button
            key={index}
            onClick={() => handleThumbnailClick(index)}
            className="mb-2"
          >
            <img
              src={image}
              alt={`Thumbnail ${index + 1}`}
              className={`w-16 h-16 object-cover rounded-lg border-2 ${
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
