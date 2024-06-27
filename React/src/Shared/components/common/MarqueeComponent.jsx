// src/Marquee.js
import React from "react";
import "../../../assets/css/Marquee.css";

const Marquee = ({ fixedText, scrollingTexts }) => {
  return (
    <div className="marquee-container">
      <div className="fixed-text">{fixedText}</div>
      <div className="marquee">
        <div className="marquee-content">
          {scrollingTexts.map((text, index) => (
            <span key={index}>{text}</span>
          ))}
          {scrollingTexts.map((text, index) => (
            <span key={scrollingTexts.length + index}>{text}</span> // Duplicate for continuous effect
          ))}
        </div>
      </div>
    </div>
  );
};

export default Marquee;
