import React, { useEffect, useState } from "react";
import LatestNewsSectionComponent from "../../common/LatestNewsSectionComponent";
import "../../../../assets/css/Home.css";
import axios from "axios";

const HomeComponent = () => {
  const [games, setGames] = useState([]);
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
  useEffect(() => {
    ListAllGames();
  }, []);
  return (
    <div>
      <section className="page-info-section set-bg">
        <img
          src="img/page-top-bg/6.jpg"
          style={{ width: "100%", height: "100%" }}
        />

        <div className="pi-content">
          <div className="container">
            <div className="row">
              <div className="col-xl-5 col-lg-6 text-white">
                <h2
                  style={{
                    fontFamily: "Arial, sans-serif",
                    fontSize: "2.5rem",
                    color: "#ffffff",
                    fontWeight: "bold",
                  }}
                >
                  Bee Home
                </h2>
                <p>
                  Welcome to BeeGaming, where gaming enthusiasts can immerse
                  themselves in a diverse collection of thrilling and engaging
                  titles. Whether you're a fan of intense shooters, strategic
                  RPGs, or captivating simulations, our platform offers
                  something for everyone.
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <div className="list-keyword d-flex justify-content-center text-center">
        <span>Featured products</span>
        <span>Featured keywords</span>
        <span>Bestselling products</span>
        <span>New arrivals</span>
      </div>
      <h4 style={{ margin: "15px", marginTop: "30px" }}>Featured products</h4>

      <div className="row" style={{ paddingLeft: "25px" }}>
        {games.map((game) => (
          <div className="col-3" key={game.id}>
            <div className="card" style={{ border: "1px solid transparent" }}>
              <img
                src={`/img/recent-game/${game.image}`}
                className="card-img-top"
                alt="..."
                height={180}
                style={{ borderRadius: "15px" }}
              />
              <div className="card-body">
                <h5 className="card-title">{game.name}</h5>
                <p className="card-text">
                  {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                </p>
                <a href={`/gamedetail/${game.id}`} className="btn btn-primary">
                  Buy Now
                </a>
              </div>
            </div>
          </div>
        ))}
      </div>

      <h4
        style={{
          margin: "15px",
          marginTop: "50px",
          borderTop: "1px solid #ccc",
          paddingTop: "35px",
        }}
      >
        Featured keywords
      </h4>
      <div className="d-flex list-keyword-finding text-center justify-content-center text-align-center">
        <button type="button" class="btn btn-primary">
          Work
        </button>
        <button type="button" class="btn btn-secondary">
          Relax
        </button>
        <button type="button" class="btn btn-success">
          Study
        </button>
        <button type="button" class="btn btn-danger">
          Spofity
        </button>
        <button type="button" class="btn btn-warning">
          Wallet
        </button>
        <button type="button" class="btn btn-info">
          Youtube
        </button>
      </div>
      <h4
        style={{
          margin: "15px",
          marginTop: "50px",
          borderTop: "1px solid #ccc",
          paddingTop: "35px",
        }}
      >
        Best Selling
      </h4>
      <div className="row" style={{ paddingLeft: "25px" }}>
        {games.map((game) => (
          <div className="col-3" key={game.id}>
            <div className="card" style={{ border: "1px solid transparent" }}>
              <img
                src={`/img/recent-game/${game.image}`}
                className="card-img-top"
                alt="..."
                height={180}
                style={{ borderRadius: "15px" }}
              />
              <div className="card-body">
                <h5 className="card-title">{game.name}</h5>
                <p className="card-text">
                  {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                </p>
                <a href={`/gamedetail/${game.id}`} className="btn btn-primary">
                  Buy Now
                </a>
              </div>
            </div>
          </div>
        ))}
      </div>
      <h4
        style={{
          margin: "15px",
          marginTop: "50px",
          borderTop: "1px solid #ccc",
          paddingTop: "35px",
        }}
      >
        Affordable Pricing
      </h4>
      <div className="d-flex list-keyword-finding text-center justify-content-center text-align-center">
        <button type="button" class="btn">
          {new Intl.NumberFormat("de-DE").format(20000)}đ
        </button>
        <button type="button" class="btn">
          {new Intl.NumberFormat("de-DE").format(50000)}đ
        </button>
        <button type="button" class="btn">
          {new Intl.NumberFormat("de-DE").format(100000)}đ
        </button>
        <button type="button" class="btn">
          {new Intl.NumberFormat("de-DE").format(200000)}đ
        </button>
        <button type="button" class="btn">
          {new Intl.NumberFormat("de-DE").format(500000)}đ
        </button>
        <button type="button" class="btn">
          {new Intl.NumberFormat("de-DE").format(1000000)}đ
        </button>
      </div>
      <h4
        style={{
          margin: "15px",
          marginTop: "50px",
        }}
      >
        Game on Steam
      </h4>
      <p style={{ margin: "15px", marginTop: "-15px" }}>
        Highly-rated games with captivating and engaging content are waiting for
        you.
      </p>
      <div className="row" style={{ paddingLeft: "25px" }}>
        {games.map((game) => (
          <div className="col-3" key={game.id}>
            <div className="card" style={{ border: "1px solid transparent" }}>
              <img
                src={`/img/recent-game/${game.image}`}
                className="card-img-top"
                alt="..."
                height={180}
                style={{ borderRadius: "15px" }}
              />
              <div className="card-body">
                <h5 className="card-title">{game.name}</h5>
                <p className="card-text">
                  {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                </p>
                <a href={`/gamedetail/${game.id}`} className="btn btn-primary">
                  Buy Now
                </a>
              </div>
            </div>
          </div>
        ))}
      </div>
      <h4
        style={{
          margin: "15px",
          marginTop: "50px",
          borderTop: "1px solid #ccc",
          paddingTop: "35px",
        }}
      >
        New arrivals
      </h4>
      <div className="row" style={{ paddingLeft: "25px" }}>
        {games.map((game) => (
          <div className="col-3" key={game.id}>
            <div className="card" style={{ border: "1px solid transparent" }}>
              <img
                src={`/img/recent-game/${game.image}`}
                className="card-img-top"
                alt="..."
                height={180}
                style={{ borderRadius: "15px" }}
              />
              <div className="card-body">
                <h5 className="card-title">{game.name}</h5>
                <p className="card-text">
                  {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                </p>
                <a href={`/gamedetail/${game.id}`} className="btn btn-primary">
                  Buy Now
                </a>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default HomeComponent;
