import React from "react";
import "../../assets/css/Footer.css";

const FooterComponent = () => {
  return (
    <footer class="steam-footer" style={{ marginTop: "80px" }}>
      <div class="footer-content">
        <div class="footer-section">
          <h2>About Steam</h2>
          <ul>
            <li>
              <a href="#">Game Info</a>
            </li>
            <li>
              <a href="#">Community</a>
            </li>
            <li>
              <a href="#">Contact</a>
            </li>
          </ul>
        </div>
        <div class="footer-section">
          <h2>Legal</h2>
          <ul>
            <li>
              <a href="#">Terms of Service</a>
            </li>
            <li>
              <a href="#">Privacy Policy</a>
            </li>
            <li>
              <a href="#">Cookie Policy</a>
            </li>
          </ul>
        </div>
        <div class="footer-section">
          <h4>Connect</h4>
          <ul class="social-links">
            <li>
              <a href="#">
                <img src="img/icons/facebook.png" alt="Facebook" />
              </a>
            </li>
            <li>
              <a href="#">
                <img src="img/icons/twitter.png" alt="Twitter" />
              </a>
            </li>
            <li>
              <a href="#">
                <img src="img/icons/instagram.png" alt="Instagram" />
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="footer-bottom">
        <p>&copy; 2024 Steam. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default FooterComponent;
