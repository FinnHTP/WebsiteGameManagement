import axios from "axios";
import React, { useEffect, useState } from "react";
import "../../../../assets/css/GameDetail.css";
import { useParams } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
const GameDetailComponent = () => {
  const [comments, setComments] = useState([]);
  const [showToast, setShowToast] = useState(false);
  const [showSuccess, setShowSuccess] = useState(false);
  const [showError, setShowError] = useState(false);
  const [avatarUrl, setAvatarUrl] = useState(null);
  const [gameRequirementsMinimum, setGameRequirementsMinimum] = useState([]);
  const [gameRequirementsRecommend, setGameRequirementsRecommend] = useState(
    []
  );

  const [content, setContent] = useState("");
  const [accountId, setAccountId] = useState(0);
  const [account, setAccount] = useState({});
  const [game, setGame] = useState({});
  const [gameId, setGameId] = useState(0);
    const [favorite, setFavorite] = useState({});
  const [parentId, setParentId] = useState(null); // State to store parentId
  const { id } = useParams();
  const [Waslike, setWaslike] = useState(false);

  const handleContent = (e) => setContent(e.target.value);

  const createCommentAndRefreshList = async (e) => {
    const token = localStorage.getItem("accesstoken");
    if (token) {
      e.preventDefault();
      try {
        const decodedToken = jwtDecode(token);
        const accountId = decodedToken.id;
        const accountEmail = decodedToken.email;

        const comment = {
          account: { id: accountId, email: accountEmail },
          content,
          parentId: parentId,
        };

        if (!token) {
          throw new Error("Không có token được tìm thấy");
        }

        const response = await axios.post(
          `http://localhost:8080/api/comment/${id}`,
          comment,
          {
            headers: {
              "Content-Type": "application/json",
              Authorization: `Bearer ${token}`,
            },
          }
        );

        setComments([...comments, response.data]);
        setContent("");
        setParentId(null);
      } catch (error) {
        console.error("Lỗi khi gửi bình luận:", error);
      }
    }
  };
  const uploadAvatar = async (accountId, file) => {
    const token = localStorage.getItem("accesstoken");
  
      const formData = new FormData();
      formData.append('avatar', file);
  
      try {
          const response = await axios.post(`http://localhost:8080/api/user/${accountId}/avatar`, formData, {
              headers: {
                  'Content-Type': 'multipart/form-data',
                  Authorization: `Bearer ${token}`,
              }
          });
          handleGetAvatar();
          console.log('Avatar uploaded successfully:', response.data);
      } catch (error) {
          console.error('Failed to upload avatar:', error.response ? error.response.data : error.message);
      }
  };
  
  const getAvatar = async (accountId) => {
    try {
        const response = await axios.get(`http://localhost:8080/api/user/${accountId}/avatar`, {
            responseType: 'arraybuffer'
        });
  
        const blob = new Blob([response.data], { type: response.headers['content-type'] });
        const url = URL.createObjectURL(blob);
        console.log(url);
        return url; // Trả về URL để bạn có thể sử dụng trong thẻ <img>
    } catch (error) {
        console.error('Failed to get avatar:', error.response ? error.response.data : error.message);
    }
  };

  const getGameById = async (gameId) => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/games/${gameId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      setGame(response.data);
    } catch (error) {
      console.error("Fail To Request:", error);
    }
  };
  const buyGame = async (e) => {
    const token = localStorage.getItem("accesstoken");
    if (token) {
      try {
        const decodedToken = jwtDecode(token);
        const accountId = decodedToken.id;
        const responseAccount = await axios.get(`http://localhost:8080/api/account/${accountId}`, {
            headers:{
              "Content-Type": "application/json",
              Authorization : `Bearer ${token}`,
            }
        })
        const accountBalance = responseAccount.data.accountBalance;
        const account = { id: accountId };
        const gameId = game.id;
        const price = game.priceGame;
        const order = { accountId, gameId, price };

        if (!token) {
          throw new Error("Token Not Found");
        }

        const response = await axios.post(
          `http://localhost:8080/api/orders`,
          order,
          {
            headers: {
              "Content-Type": "application/json",
              Authorization: `Bearer ${token}`,
            },
          }
        );
        console.log(response.status);
        if (response.status === 201) {
          setShowSuccess(true); // Hiển thị thông báo thành công
          // Cập nhật số dư tài khoản

          const updatedAccount = {
            accountBalance: accountBalance - game.priceGame,
          };
          console.log(accountBalance);
          const updateBalanceResponse = await axios.put(
            `http://localhost:8080/api/account/${accountId}/accountBalance`,
            updatedAccount,
            {
              headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
              },
            }
          );
          console.log("Update balance response:", updateBalanceResponse.data);
        } else {
          setShowError(true);
        }
      } catch (error) {
        console.error("Fail Error:", error);
      }
    }
  };
  const handleGetAvatar = async () => {
    const token = localStorage.getItem("accesstoken");
    const decoded = jwtDecode(token);
    const accountId = decoded.id;
    const url = await getAvatar(accountId, token);
    setAvatarUrl(url);
};

  const listAllComments = async () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Token Not Found");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/comment/findByGame/${id}`,
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

      setComments(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Fail to Request", error);
    }
  };


  const addFavorite = async () => {
    const token = localStorage.getItem("accesstoken");
    const decodedToken = jwtDecode(token);
    const accountId = decodedToken.id;
    const gameId = game.id;



    if (!token) {
      console.error("Token Not Found");
      return;
    }
    const favorite = {
      account: { id: accountId},
      isActive:1,
      game: {id: gameId}
    };
    try {
      const response = await axios.post(
        `http://localhost:8080/api/favorites`, favorite,
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

      setFavorite(Array.isArray(data) ? data : []);
        if(response.status === 201)
        {
          setWaslike(true)
        }
    } catch (error) {
      console.error("Error", error);
    }
  };






  const listGameRequirements = async () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/gameSystemRequirement/findByGame/${id}`,
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

      setGameRequirementsMinimum(data[0]);
      setGameRequirementsRecommend(data[1]);
      console.log(gameRequirementsMinimum);
      console.log(gameRequirementsRecommend);
    } catch (error) {
      console.error("Lỗi khi gửi yêu cầu:", error);
    }
  };
  const handleCloseNotification = () => {
    setShowSuccess(false);
    setShowError(false);
  };

  const buildCommentTree = (comments) => {
    const map = {};
    const roots = [];

    comments.forEach((comment) => {
      map[comment.id] = { ...comment, children: [] };
    });

    comments.forEach((comment) => {
      if (comment.parentId) {
        map[comment.parentId].children.push(map[comment.id]);
      } else {
        roots.push(map[comment.id]);
      }
    });

    return roots;
  };

  const handleReply = (comment) => {
    setParentId(comment.id); // Set parentId when reply button is clicked
    setContent(`${comment.account.email} `); //
  };

  const renderComments = (comments) => {
    return comments.map((comment) => (
      <div key={comment.id} className="comment mt-4 text-justify">
         {avatarUrl ?  <img src={avatarUrl} alt="User Avatar" width={60} style={{borderRadius:"50%"}}/> :<img
          
          src={
            "https://cdn-icons-png.flaticon.com/128/149/149071.png"
          }
          alt="User Avatar"
          width={60}
          style={{borderRadius:"50%"}}
        />}
        <h4>{comment.account ? comment.account.email : "Anonymous"}</h4>
        <span>{comment.date}</span>
        <br />
        <p>{comment.content}</p>
        <a
          onClick={() => handleReply(comment)}
          className="btn-reply"
          style={{ fontSize: "1.3rem", color: "blue" }}
        >
          Reply
        </a>
        {comment.children.length > 0 && (
          <div className="comment-child" style={{ marginLeft: "45px" }}>
            {renderComments(comment.children)}
          </div>
        )}
      </div>
    ));
  };

  useEffect(() => {
    if (id) {
      getGameById(id);
      listAllComments();
      console.log(game);
      listGameRequirements();
      handleGetAvatar()
    }
  }, [id]);

  const commentTree = buildCommentTree(comments);

  return (
    <div>
      <section>
        <div className="container">
          <div className="game-image-container">
            <div className="row mt-3">
              <div className="col-6">
                <img
                  src={`/img/recent-game/${game.image}`}
                  alt="Game Banner"
                  className="game-banner"
                  width={430}
                />
              </div>
              <div
                className={`backdrop ${showSuccess || showError ? "show" : ""}`}
              ></div>
              <div
                className={`notification ${showSuccess ? "show success" : ""}`}
              >
                <div className="notification-content">
                  <img
                    src={`/img/recent-game/${game.image}`}
                    alt="Game Banner"
                  />
                  <span style={{ color: "green", fontSize: "1.6rem" }}>
                    Purchase Successful
                  </span>
                  <h4>Thank You!</h4>
                  <button
                    className="notification-button"
                    onClick={handleCloseNotification}
                  >
                    Close
                  </button>
                </div>
              </div>

              {/* Thông báo thất bại */}
              <div className={`notification ${showError ? "show error" : ""}`}>
                <div className="notification-content">
                  Purchase Failed
                  <button
                    className="notification-button"
                    onClick={handleCloseNotification}
                  >
                    Close
                  </button>
                </div>
              </div>
              <div className="col-3 text-left">
                <p className="name-game-detail">{game.name}</p>
                <p className="price-game-detail">
                  Price:{" "}
                  <strong>
                    {new Intl.NumberFormat("de-DE").format(game.priceGame)}đ{" "}
                  </strong>{" "}
                </p>
                <p className="releaseDate-game-detail">
                  Release Date: <strong>{game.releaseDate}</strong>
                </p>
                <p className="version-game-detail">
                  Version: <strong>{game.version}</strong>
                </p>

                {game.status ? (
                  <p style={{ color: "#000" }}>
                    <img
                      src="/img/icons/box.png"
                      alt=""
                      width={18}
                      style={{ marginRight: "3px" }}
                    />
                    Status:{" "}
                    <strong style={{ color: "green", fontSize: "1.5rem" }}>
                      Stocking
                    </strong>
                  </p>
                ) : (
                  <p style={{ color: "#000" }}>
                    <img
                      src="/img/icons/box.png"
                      alt=""
                      width={18}
                      style={{ marginRight: "3px" }}
                    />
                    Status:{" "}
                    <strong style={{ color: "red", fontSize: "1.5rem" }}>
                      Out of Stock
                    </strong>
                  </p>
                )}
                <div
                  className="btn bg-dark text-center"
                  style={{
                    color: "white",
                    width: "150px",
                    height: "40px",
                    fontSize: "17px",
                    marginTop: "9px",
                  }}
                  onClick={buyGame}
                >
                  Buy Game
                </div>

                <div
                  className="btn bg-dark text-center"
                  style={{
                    color: "white",
                    width: "150px",
                    height: "40px",
                    fontSize: "17px",
                    marginTop: "9px",
                  }}
                  onClick={addFavorite}
                >
                  {Waslike ? 'Was liked' : 'Add to favorite'}
                </div>

              </div>
              <div className="col-3">
                <div>
                  <img
                    src="/img/icons/code.png"
                    alt="Icons"
                    width={20}
                    style={{ opacity: "0.8", marginBottom: "6px" }}
                  />
                  <span
                    className="gameType-game-detail"
                    style={{
                      marginLeft: "10px",
                      marginTop: "13px",
                      display: "inline-block",
                    }}
                  >
                    GameType: {game.gameType?.name}
                  </span>
                </div>
              </div>
            </div>
          </div>
          <div
            className="row text-center justify-content-center"
            style={{ marginTop: "80px" }}
          >
            <div
              className="tutorial text-center"
              style={{
                border: "1px solid #ccc",
                padding: "25px 200px",
                borderRadius: "10px",
              }}
            >
              <p>
                To buy this game, click on the{" "}
                <strong style={{ color: "#000", fontSize: "1.3rem" }}>
                  "Buy Game"
                </strong>{" "}
                button to let the system select the appropriate products. <br />
                Refer to the instructions{" "}
                <strong style={{ color: "#000", fontSize: "1.3rem" }}>
                  "HERE"
                </strong>{" "}
                <br />
                <strong style={{ color: "#f00", fontSize: "1.3rem" }}>
                  Notes:{" "}
                </strong>
                Game prices on Bee may not be updated due to Steam changes.
                Please click on Products on Steam to <br />
                update the most accurate price and select the appropriate Wallet
                code.
              </p>
            </div>
          </div>
          <div className="row" style={{ marginLeft: "5px", marginTop: "10px" }}>
            <div className="col-2">
              <h5>Detail Game</h5>
            </div>
            <div className="col-9">
              <p> {game.description} </p>
            </div>
            <div className="col-1"></div>
          </div>
          <div className="row" style={{ marginLeft: "5px", marginTop: "10px" }}>
            <div className="col-2">
              <h5>Requirements</h5>
            </div>
            <div className="col-9 list-configuration">
              <div className="row">
                <div className="col-6">
                  <h4 style={{ color: "#838383", fontSize: "1.5rem" }}>
                    Minimum
                  </h4>
                  <div className="card" style={{ border: "none" }}>
                    {gameRequirementsMinimum ? (
                      <ul
                        className="list-gameRequirements"
                        key={gameRequirementsMinimum.id}
                      >
                        <li className="list-gameRequirements-item">
                          <i style={{ fontSize: "1.5rem", color: "#838383" }}>
                            {" "}
                            * Requires a 64-bit proccessor and operating system
                          </i>
                        </li>
                        <li className="list-gameRequirements-item">
                          <span>OS:</span> {gameRequirementsMinimum.os}
                        </li>
                        <li className="list-gameRequirements-item">
                          <span>Proccessor:</span>{" "}
                          {gameRequirementsMinimum.proccessor}
                        </li>
                        <li className="list-gameRequirements-item">
                          <span>Memory:</span> {gameRequirementsMinimum.memory}
                        </li>
                        <li className="list-gameRequirements-item">
                          <span>Graphic:</span> {gameRequirementsMinimum.card}
                        </li>
                        <li className="list-gameRequirements-item">
                          <span>Storage:</span>{" "}
                          {gameRequirementsMinimum.storage}
                        </li>
                      </ul>
                    ) : (
                      <p style={{ fontSize: "2rem" }}>
                        No Information about This Game
                      </p>
                    )}
                  </div>
                </div>
                <div className="col-6" style={{ borderLeft: "1px solid #ccc" }}>
                  <h4 style={{ color: "#838383", fontSize: "1.5rem" }}>
                    Recommended
                  </h4>
                  {gameRequirementsRecommend ? (
                    <ul
                      className="list-gameRequirements"
                      key={gameRequirementsRecommend.id}
                    >
                      <li className="list-gameRequirements-item">
                        <i style={{ fontSize: "1.5rem", color: "#838383" }}>
                          {" "}
                          * Requires a 64-bit proccessor and operating system
                        </i>
                      </li>
                      <li className="list-gameRequirements-item">
                        <span>OS:</span> {gameRequirementsRecommend.os}
                      </li>
                      <li className="list-gameRequirements-item">
                        <span>Proccessor</span>:{" "}
                        {gameRequirementsRecommend.proccessor}
                      </li>
                      <li className="list-gameRequirements-item">
                        <span>Memory</span>: {gameRequirementsRecommend.memory}
                      </li>
                      <li className="list-gameRequirements-item">
                        <span>Graphic:</span> {gameRequirementsRecommend.card}
                      </li>
                      <li className="list-gameRequirements-item">
                        <span>Storage:</span>{" "}
                        {gameRequirementsRecommend.storage}
                      </li>
                    </ul>
                  ) : (
                    <p style={{ fontSize: "1.4rem" }}>
                      No Information about This Game
                    </p>
                  )}
                </div>
              </div>
            </div>
            <div className="col-1"></div>
          </div>

          <div className="row">
            <div className="col-12 pb-4">
              <form id="align-form">
                <div className="form-group">
                  <h5>Comment</h5>
                  <textarea
                    name="msg"
                    id="msg"
                    cols="30"
                    rows="5"
                    className="form-control-textarea"
                    onChange={handleContent}
                    value={content}
                  ></textarea>
                </div>

                <div className="form-group">
                  <button
                    type="button"
                    id="post"
                    className="btn"
                    onClick={createCommentAndRefreshList}
                  >
                    Send
                  </button>
                </div>
              </form>
              <h5
                style={{
                  borderBottom: "1px solid #ccc",
                  paddingBottom: "10px",
                }}
              ></h5>
              {comments.length === 0 ? (
                <p
                  style={{
                    textAlign: "center",
                    fontSize: "1.6rem",
                    marginTop: "30px",
                  }}
                >
                  Leave Your Comment Here.
                </p>
              ) : (
                renderComments(commentTree)
              )}
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default GameDetailComponent;
