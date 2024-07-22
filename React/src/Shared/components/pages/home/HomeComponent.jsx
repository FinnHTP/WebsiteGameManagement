import React, { useEffect, useState } from "react";
import LatestNewsSectionComponent from "../../common/LatestNewsSectionComponent";
import "../../../../assets/css/Home.css";
import axios from "axios";
import Carousel from "../../CarouselComponent";

const HomeComponent = () => {
  const [games, setGames] = useState([]);
  const gamesToShow = games.slice(0, 5);
  const gameDiscounts = games.slice(0, 4);
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
        <div className="text-center bg-black">
          <img
            src="img/page-top-bg/6.jpg"
            style={{
              width: "75%",
              height: "500px",
            }}
          />
        </div>
      </section>
      <div className="list-keyword d-flex justify-content-center text-center">
        <span>Featured Discounts</span>
        <span>Featured Products</span>
        <span>Featured Keywords</span>
        <span>Bestselling Products</span>
        <span>New Arrivals</span>
      </div>
      <div className="container">
        <h2 style={{ margin: "15px", marginTop: "30px", fontSize: "2.5rem" }}>
          Featured products
        </h2>
        {/* <div className="d-flex justify-content-center text-center">
          <div>
            <img src="img/recent-game/callofduty.jpg" alt="" height={400} />
          </div>
          <div className="collect-gametypes">
            <div>
              <img src="img/recent-game/gta-vi.jpg" alt="" width={152} />
              <img
                src="img/recent-game/red-dead-redemption-2.jpg"
                alt=""
                width={152}
                height={187}
              />
            </div>

            <div className="mt-3">
              <img src="img/recent-game/cyperpunk.jpg" alt="" width={152} />
              <img
                src="img/recent-game/city-skylines.jpg"
                alt=""
                height={202}
                width={152}
              />
            </div>
          </div>
        </div> */}
        <Carousel games={gamesToShow}></Carousel>
        <h4
          style={{
            margin: "15px",
            marginTop: "50px",
            borderTop: "1px solid #ccc",
            paddingTop: "35px",
            fontSize: "2.5rem",
          }}
        >
          Featured Discounts
        </h4>
        <div className="row" style={{ paddingLeft: "25px" }}>
          {gameDiscounts.map((game) => (
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
                  <p
                    className="card-text"
                    style={{
                      fontSize: "1.5rem",
                      color: "white",
                      fontWeight: "bold",
                    }}
                  >
                    <del
                      style={{
                        fontSize: "1.5rem",
                        color: "#ccc",
                        paddingRight: "10px",
                      }}
                    >
                      {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                    </del>
                    {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                  </p>
                  <div
                    className="btn btn-danger px-4"
                    style={{ fontWeight: "bold" }}
                  >
                    -50%
                  </div>
                  <div
                    className=""
                    style={{
                      position: "absolute",
                      top: "0",
                      right: "0",
                      marginRight: "2px",
                      borderTopLeftRadius: "0px",
                      borderTopRightRadius: "0px",
                      paddingBottom: "10px",
                    }}
                  >
                    <img src="img/icons/tag.png " alt="" width={45} />
                  </div>
                  <a
                    href={`/gamedetail/${game.id}`}
                    className="btn btn-success"
                    style={{
                      padding: "7px",
                      fontSize: "1.3rem",
                      position: "relative",
                      left: "46%",
                    }}
                  >
                    Detail More
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
            fontSize: "2.5rem",
          }}
        >
          Game on Steam
        </h4>
        <div className="row mx-5 text-center justify-content-center">
          <div className="col-3 header-list-game">
            <div
              className="d-flex"
              style={{
                borderBottom: "1px solid #616161",
                paddingBottom: "15px",
              }}
            >
              <h3>Best Sellings</h3>
              <div
                className="btn btn-header-list-game border-light text-light"
                style={{
                  borderRadius: "0px",
                  marginLeft: "100px",
                  paddingBottom: "0px",
                }}
              >
                VIEW MORE
              </div>
            </div>
            <div className="">
              {gamesToShow.map((game) => (
                <div className="d-flex item-header-list-game">
                  <img
                    src={`/img/recent-game/${game.image}`}
                    className="card-img-top"
                    alt="..."
                    style={{
                      borderRadius: "15px",
                      width: "110px",
                      height: "80px",
                    }}
                  />
                  <div className="mt-2">
                    <p style={{ fontSize: "1.19rem", marginLeft: "10px" }}>
                      {game.name}
                    </p>
                    <p style={{ fontSize: "1.3rem", marginLeft: "20px" }}>
                      {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                    </p>
                  </div>
                </div>
              ))}
            </div>
          </div>
          <div className="col-3 header-list-game">
            <div
              className="d-flex"
              style={{
                borderBottom: "1px solid #616161",
                paddingBottom: "15px",
              }}
            >
              <h3>Most Played</h3>
              <div
                className="btn btn-header-list-game border-light text-light"
                style={{
                  borderRadius: "0px",
                  marginLeft: "100px",
                  paddingBottom: "0px",
                }}
              >
                VIEW MORE
              </div>
            </div>
            <div className="">
              {gamesToShow.map((game) => (
                <div className="d-flex item-header-list-game">
                  <img
                    src={`/img/recent-game/${game.image}`}
                    className="card-img-top"
                    alt="..."
                    style={{
                      borderRadius: "15px",
                      width: "110px",
                      height: "80px",
                    }}
                  />
                  <div className="mt-2">
                    <p style={{ fontSize: "1.19rem", marginLeft: "10px" }}>
                      {game.name}
                    </p>
                    <p style={{ fontSize: "1.3rem", marginLeft: "20px" }}>
                      {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                    </p>
                  </div>
                </div>
              ))}
            </div>
          </div>
          <div className="col-3 header-list-game">
            <div
              className="d-flex"
              style={{
                borderBottom: "1px solid #616161",
                paddingBottom: "15px",
              }}
            >
              <h3>Top Rating</h3>
              <div
                className="btn btn-header-list-game border-light text-light"
                style={{
                  borderRadius: "0px",
                  marginLeft: "100px",
                  paddingBottom: "0px",
                }}
              >
                VIEW MORE
              </div>
            </div>
            <div className="">
              {gamesToShow.map((game) => (
                <div className="d-flex item-header-list-game">
                  <img
                    src={`/img/recent-game/${game.image}`}
                    className="card-img-top"
                    alt="..."
                    style={{
                      borderRadius: "15px",
                      width: "110px",
                      height: "80px",
                    }}
                  />
                  <div className="mt-2">
                    <p style={{ fontSize: "1.19rem", marginLeft: "10px" }}>
                      {game.name}
                    </p>
                    <p style={{ fontSize: "1.3rem", marginLeft: "20px" }}>
                      {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                    </p>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
        <h2
          style={{
            margin: "15px",
            marginTop: "50px",
            borderTop: "1px solid #ccc",
            paddingTop: "35px",
            fontSize: "2.5rem",
          }}
        >
          Featured keywords
        </h2>
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
        <h2
          style={{
            margin: "15px",
            marginTop: "50px",
            fontSize: "2.2rem",
          }}
        >
          Top Rating
        </h2>
        <p
          style={{
            margin: "15px",
            marginTop: "-15px",
            fontSize: "1.5rem",
            color: "#ccc",
          }}
        >
          Highly-rated games with captivating and engaging content are waiting
          for you.
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
                  <p
                    className="card-text"
                    style={{ fontSize: "1.5rem", color: "#ccc" }}
                  >
                    {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                  </p>
                  <a
                    href={`/gamedetail/${game.id}`}
                    className="btn btn-success"
                    style={{
                      padding: "7px",
                      fontSize: "1.3rem",
                      position: "relative",
                      left: "68%",
                    }}
                  >
                    Detail More
                  </a>
                </div>
              </div>
            </div>
          ))}
        </div>
        <h2
          style={{
            margin: "15px",
            marginTop: "50px",
            borderTop: "1px solid #ccc",
            paddingTop: "35px",
            fontSize: "2.5rem",
          }}
        >
          New arrivals
        </h2>
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
                  <p
                    className="card-text"
                    style={{ fontSize: "1.5rem", color: "#ccc" }}
                  >
                    {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                  </p>
                  <a
                    href={`/gamedetail/${game.id}`}
                    className="btn btn-success"
                    style={{
                      padding: "7px",
                      fontSize: "1.3rem",
                      position: "relative",
                      left: "68%",
                    }}
                  >
                    Detail More
                  </a>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default HomeComponent;
