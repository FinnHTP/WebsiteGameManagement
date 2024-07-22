import React, { useState, useEffect, useRef } from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import "../../assets/css/Carousel.css";

const Carousel = ({ games }) => {
  const [currentSlide, setCurrentSlide] = useState(0);
  const sliderRef = useRef(null);

  const settings = {
    dots: true,
    infinite: true,
    speed: 800,
    slidesToShow: 1,
    slidesToScroll: 1,
    beforeChange: (oldIndex, newIndex) => setCurrentSlide(newIndex),
  };

  const handleClick = (index) => {
    setCurrentSlide(index);
    sliderRef.current.slickGoTo(index);
  };

  useEffect(() => {
    if (sliderRef.current) {
      sliderRef.current.slickGoTo(currentSlide);
    }
  }, [currentSlide]);

  return (
    <div className="carousel-wrapper">
      <div className="carousel-container">
        <Slider {...settings} ref={sliderRef}>
          {games.map((game) => (
            <div key={game.id} className="carousel-slide">
              <div className="slide-content">
                <img
                  src={`img/recent-game/${game.image}`}
                  alt={game.name}
                  className="slide-image"
                />
                <div className="slide-overlay">
                  <h2>{game.name}</h2>
                  <p>{game.description}</p>
                  <p
                    className="price"
                    style={{
                      fontSize: "1.6rem",
                      color: "white",
                      fontWeight: "bold",
                    }}
                  >
                    {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                  </p>
                  <div className="d-flex" style={{ marginTop: "-1px" }}>
                    <button className="details-button">Buy Now</button>
                    <span
                      className="add-to-favorite"
                      style={{
                        marginLeft: "15px",
                        fontSize: "1.5rem",
                        marginTop: "8px",
                        color: "white",
                      }}
                    >
                      <strong
                        style={{
                          fontSize: "1.5rem",
                          color: "white",
                        }}
                      >
                        ⓥ
                      </strong>{" "}
                      ADD TO FAVORITE
                    </span>
                  </div>
                </div>
              </div>
            </div>
          ))}
        </Slider>
      </div>
      <div className="game-list">
        {games.map((game, index) => (
          <div
            key={game.id}
            className={`game-item ${index === currentSlide ? "active" : ""}`}
            onClick={() => handleClick(index)}
          >
            <div className="d-flex m-2">
              <img
                src={`img/recent-game/${game.image}`}
                alt={game.name}
                className="thumbnail"
              />
              <h5 style={{ marginLeft: "5px" }}>{game.name}</h5>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Carousel;
