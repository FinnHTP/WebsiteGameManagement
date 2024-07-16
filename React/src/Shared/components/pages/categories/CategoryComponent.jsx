import React, { useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const CategoryComponent = () => {
  const [games, setGames] = useState([]);
  const navigator = useNavigate();
  function linkComment(id) {
    navigator(`/gamedetail/${id}`);
  }
  const ListAllGames = async () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get("http://localhost:8080/api/games", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

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
                <h2>Bee Blog</h2>
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

      <section className="page-section recent-game-page spad">
        <div className="container">
          <div className="row">
            <div className="col-lg-8">
              <div className="row">
                {games.map((game) => (
                  <div className="col-md-6">
                    <div className="recent-game-item" key={game.id}>
                      <div className="rgi-thumb set-bg">
                        <img
                          src={`img/recent-game/${game.image}`}
                          alt="game1"
                        />
                        <div className="cata new"></div>
                      </div>
                      <div className="rgi-content">
                        <h5>{game.name}</h5>
                        <p>
                          {game.description.split(" ").slice(0, 10).join(" ")}
                          {game.description.split(" ").length > 10 &&
                            " ..."}{" "}
                        </p>
                        <a
                          onClick={() => linkComment(game.id)}
                          className="comment-game"
                          style={{ fontSize: "1.3rem" }}
                        >
                          3 Comments
                        </a>
                        <div className="rgi-extra">
                          <div className="rgi-star">
                            <img src="img/icons/star.png" alt="" />
                          </div>
                          <div className="rgi-heart">
                            <img src="img/icons/heart.png" alt="" />
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
              <div className="site-pagination">
                <span className="active">01.</span>
                <a href="#">02.</a>
                <a href="#">03.</a>
              </div>
            </div>

            <div className="col-lg-4 col-md-7 sidebar pt-5 pt-lg-0">
              <div className="widget-item">
                <form className="search-widget">
                  <input type="text" placeholder="Search" />
                  <button>
                    <i className="fa fa-search"></i>
                  </button>
                </form>
              </div>

              <div className="widget-item">
                <h4 className="widget-title">Latest Posts</h4>
                <div className="latest-blog">
                  <div className="lb-item">
                    <div className="lb-thumb set-bg">
                      <img src="img/latest-blog/1.jpg" alt="game1" />
                    </div>
                    <div className="lb-content">
                      <div className="lb-date">June 21, 2018</div>
                      <p>
                        Ipsum dolor sit amet, consectetur adipisc ing consecips
                      </p>
                      <a href="#" className="lb-author">
                        By Admin
                      </a>
                    </div>
                  </div>
                  <div className="lb-item">
                    <div className="lb-thumb set-bg">
                      <img src="img/latest-blog/2.jpg" alt="game2" />
                    </div>
                    <div className="lb-content">
                      <div className="lb-date">June 21, 2018</div>
                      <p>
                        Ipsum dolor sit amet, consectetur adipisc ing consecips
                      </p>
                      <a href="#" className="lb-author">
                        By Admin
                      </a>
                    </div>
                  </div>
                  <div className="lb-item">
                    <div className="lb-thumb set-bg">
                      <img src="img/latest-blog/3.jpg" alt="game3" />
                    </div>
                    <div className="lb-content">
                      <div className="lb-date">June 21, 2018</div>
                      <p>
                        Ipsum dolor sit amet, consectetur adipisc ing consecips
                      </p>
                      <a href="#" className="lb-author">
                        By Admin
                      </a>
                    </div>
                  </div>
                </div>
              </div>

              <div className="widget-item">
                <h4 className="widget-title">Top Comments</h4>
                <div className="top-comment">
                  <div className="tc-item">
                    <div className="tc-thumb set-bg">
                      <img src="img/authors/1.jpg" alt="person1" />
                    </div>
                    <div className="tc-content">
                      <p>
                        <a href="#">James Smith</a> <span>on</span> Lorem consec
                        ipsum dolor sit amet, co
                      </p>
                      <div className="tc-date">June 21, 2018</div>
                    </div>
                  </div>
                  <div className="tc-item">
                    <div className="tc-thumb set-bg">
                      <img src="img/authors/2.jpg" alt="person2" />
                    </div>
                    <div className="tc-content">
                      <p>
                        <a href="#">Michael James</a> <span>on</span>Cras sit
                        amet sapien aliquam
                      </p>
                      <div className="tc-date">June 21, 2018</div>
                    </div>
                  </div>
                  <div className="tc-item">
                    <div className="tc-thumb set-bg">
                      <img src="img/authors/3.jpg" alt="person3" />
                    </div>
                    <div className="tc-content">
                      <p>
                        <a href="#">Justin More</a> <span>on</span> Lorem ipsum
                        dolor consecsit amet, co
                      </p>
                      <div className="tc-date">June 21, 2018</div>
                    </div>
                  </div>
                </div>
              </div>

              <div className="widget-item">
                <div className="feature-item set-bg">
                  <img
                    src="img/features/1.jpg"
                    alt="game1"
                    style={{ height: "100%", width: "100%" }}
                  />
                  <span className="cata new">new</span>
                  <div className="fi-content text-white">
                    <h5>
                      <a href="#">Suspendisse ut justo tem por, rutrum</a>
                    </h5>
                    <p>
                      Lorem ipsum dolor sit amet, consectetur adipiscing elit.{" "}
                    </p>
                    <a href="#" className="fi-comment">
                      3 Comments
                    </a>
                  </div>
                </div>
              </div>

              <div className="widget-item">
                <div className="review-item">
                  <div className="review-cover set-bg">
                    <img
                      src="img/review/1.jpg"
                      alt="game1"
                      style={{ height: "350px", width: "100%" }}
                    />
                    <div className="score yellow">9.3</div>
                  </div>
                  <div className="review-text">
                    <h5>Assasin’’s Creed</h5>
                    <p>
                      Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum
                      dolor sit ame.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default CategoryComponent;
