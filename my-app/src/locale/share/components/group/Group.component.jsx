import React, { useEffect, useState } from "react";
import axios from "axios";
import { jwtDecode } from "jwt-decode";
import { useNavigate } from "react-router-dom";
import { navigate } from "react-router-dom";
// import { getAvatar } from "./AvatarComponent";

const GroupComponent = () => {
  const [games, setGames] = useState([]);
  const [selectedGroup, setSelectedGroup] = useState(null);
  const [groups, setGroups] = useState([]);
  const [joinedGroups, setJoinedGroups] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [blogs, setBlogs] = useState([]);
  const navigate = useNavigate();
  const [members, setMembers] = useState([]);

  const [avatar, setAvatar] = useState("");
  const [avatarUrl, setAvatarUrl] = useState(null);
  const [groupId, setGroupId] = useState(0);

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
      setGames(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Lỗi khi gửi yêu cầu:", error);
    }
  };

  const ListAllGroups = async () => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get("http://localhost:8080/api/group", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      const data =
        typeof response.data === "string"
          ? JSON.parse(response.data)
          : response.data;
      setGroups(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Lỗi khi gửi yêu cầu:", error);
    }
  };

  const ListAllMemberingroup = async () => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/group/member/${groupId}`,
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
      setMembers(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Lỗi khi gửi yêu cầu:", error);
    }
  };

  const fetchJoinedGroups = async () => {
    const token = localStorage.getItem("accesstoken");
    const decode = jwtDecode(token);
    const accountId = decode.id;

    try {
      const joinedGroupsPromises = groups.map(async (group) => {
        const response = await axios.get(
          `http://localhost:8080/api/group/${group.id}/isUserJoined`,
          {
            params: { accountId },
            headers: {
              Authorization: `Bearer ${token}`,
            },
          }
        );
        return response.data ? group.id : null;
      });

      const results = await Promise.all(joinedGroupsPromises);
      setJoinedGroups(results.filter(Boolean));
    } catch (error) {
      console.error("Lỗi khi kiểm tra nhóm đã tham gia:", error);
    }
  };

  const handleJoinGroup = async (groupId) => {
    const token = localStorage.getItem("accesstoken");
    const decode = jwtDecode(token);
    const accountId = decode.id;

    if (!token) {
      console.error("Không tìm thấy token");
      return;
    }

    try {
      await axios.post(
        `http://localhost:8080/api/group/joinGroup`,
        { accountId, groupId },
        {
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );
      alert("Tham gia nhóm thành công");

      fetchJoinedGroups();
    } catch (error) {
      console.error("Lỗi khi tham gia nhóm:", error);
      alert("Tham gia nhóm thất bại");
    }
  };

  const handleLeaveGroup = async (groupId) => {
    const token = localStorage.getItem("accesstoken");
    const decode = jwtDecode(token);
    const accountId = decode.id;

    if (!token) {
      console.error("Không tìm thấy token");
      return;
    }

    try {
      await axios.post(
        `http://localhost:8080/api/group/leaveGroup`,
        { accountId, groupId },
        {
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );
      alert("Rời nhóm thành công");

      fetchJoinedGroups();
    } catch (error) {
      console.error("Lỗi khi rời nhóm:", error);
      alert("Rời nhóm thất bại");
    }
  };

  const fetchBlogsByGroup = (groupId) => {
    navigate(`/blogs/group/${groupId}`);
  };

  const getAvatar = async (groupId) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/group/member/${groupId}`,
        {
          responseType: "arraybuffer",
        }
      );
      setAvatar = response.data;
      const blob = new Blob([response.data.avatar], {
        type: response.headers["content-type"],
      });
      const url = URL.createObjectURL(blob);
      console.log(url);
      return url;
    } catch (error) {
      console.error(
        "Failed to get avatar:",
        error.response ? error.response.data : error.message
      );
    }
  };

  const handleGetAvatar = async () => {
    const url = await getAvatar(groupId);
    setAvatarUrl(url);
    console.log("Avatar: ", avatarUrl);
  };

  const handleCloseModal = () => setShowModal(false);

  useEffect(() => {
    ListAllGames();
    ListAllGroups();
    handleGetAvatar();
    ListAllMemberingroup();
  }, []);

  useEffect(() => {
    if (groups.length > 0) {
      fetchJoinedGroups();
    }
  }, [groups]);

  return (
    <div>
      <section className="page-info-section set-bg">
        {/* <img src="img/page-top-bg/6.jpg" style={{ width: "100%", height: "100%" }} /> */}
        <div className="pi-content">
          <div className="container">
            <div className="row"></div>
          </div>
        </div>
      </section>

      <section className="page-section recent-game-page spad">
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="row">
                {groups.map((group) => (
                  <div className="col-lg-12" key={group.id}>
                    <div className="m-5 p-3" style={{ background: "gray" }}>
                      <div className="recent-game-item">
                        <div className="row">
                          <div className="rgi-thumb set-bg col-xl-4">
                            <img
                              src={`img/latest-blog/${group.image}`}
                              alt="game1"
                              style={{
                                width: "200px",
                                height: "100px",
                                marginLeft: "100px",
                              }}
                            />
                            <div className="cata new"></div>
                            <span
                              style={{ fontSize: "20px", marginLeft: "100px" }}
                            >
                              Ngày tạo: {group.createDate}
                            </span>
                          </div>

                          <div className="col-xl-4">
                            <h1
                              style={{
                                marginLeft: "0px",
                                marginTop: "0px",
                                width: "200px",
                              }}
                            >
                              Nhóm: {group.name}
                            </h1>
                          </div>

                          <div
                            className="col-xl-4"
                            style={{
                              display: "flex",
                              flexDirection: "column",
                              alignItems: "center",
                            }}
                          >
                            <div
                              className="rgi-content col-xl-3"
                              style={{ marginTop: "100px", marginLeft: "80px" }}
                            >
                              {joinedGroups.includes(group.id) ? (
                                <>
                                  <button
                                    style={{ fontSize: "16px" }}
                                    className="btn btn-info"
                                    onClick={() => fetchBlogsByGroup(group.id)}
                                  >
                                    Chi tiết
                                  </button>
                                  <button
                                    style={{ fontSize: "16px" }}
                                    className="btn btn-danger mx-3"
                                    onClick={() => handleLeaveGroup(group.id)}
                                  >
                                    Thoát nhóm
                                  </button>
                                </>
                              ) : (
                                <button
                                  style={{ fontSize: "16px" }}
                                  className="btn btn-warning mx-3"
                                  onClick={() => handleJoinGroup(group.id)}
                                >
                                  Tham gia ngay
                                </button>
                              )}
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default GroupComponent;
