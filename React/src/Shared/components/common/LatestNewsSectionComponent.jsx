// import React, { useEffect } from 'react';
// import 'owl.carousel/dist/assets/owl.carousel.css';
// import 'owl.carousel/dist/assets/owl.theme.default.css';
// import 'jquery';
// import 'owl.carousel';
// import $ from 'jquery';

import "../../../assets/css/LatestNewsSection.css";
import React from "react";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

const LatestNewsSectionComponent = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
  };

  return (
    <div className="carousel-container">
      <Slider {...settings}>
        <div>
          <h3>Slide 1: Lorem ipsum dolor sit amet.</h3>
        </div>
        <div>
          <h3>Slide 2: Consectetur adipiscing elit.</h3>
        </div>
        <div>
          <h3>Slide 3: Integer molestie lorem at massa.</h3>
        </div>
        <div>
          <h3>Slide 4: Facilisis in pretium nisl aliquet.</h3>
        </div>
        <div>
          <h3>Slide 5: Nulla volutpat aliquam velit.</h3>
        </div>
      </Slider>
    </div>
  );
};

export default LatestNewsSectionComponent;
