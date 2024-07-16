import React, { useEffect, useState } from "react";
import axios from "axios";
import { jwtDecode } from "jwt-decode";
import { useNavigate } from "react-router-dom";
import { navigate } from 'react-router-dom';
import { Table, Modal, Button } from "react-bootstrap";

const GroupComponent = () => {
  const [games, setGames] = useState([]);
  const [selectedGroup, setSelectedGroup] = useState(null);
  const [groups, setGroups] = useState([]);
  const [joinedGroups, setJoinedGroups] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [blogs, setBlogs] = useState([]);
  const navigate = useNavigate();

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
      const data = typeof response.data === "string" ? JSON.parse(response.data) : response.data;
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
      const data = typeof response.data === "string" ? JSON.parse(response.data) : response.data;
      setGroups(Array.isArray(data) ? data : []);
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
        const response = await axios.get(`http://localhost:8080/api/group/${group.id}/isUserJoined`, {
          params: { accountId },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
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
            'Content-Type': 'application/json'
          }
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
            'Content-Type': 'application/json'
          }
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



  const handleCloseModal = () => setShowModal(false);

  useEffect(() => {
    ListAllGames();
    ListAllGroups();
  }, []);

  useEffect(() => {
    if (groups.length > 0) {
      fetchJoinedGroups();
    }
  }, [groups]);

  return (
    <div>
      <section className="page-info-section set-bg">
        <img src="img/page-top-bg/6.jpg" style={{ width: "100%", height: "100%" }} />
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
                {/* <Modal show={showModal} onHide={handleCloseModal}>
                  <Modal.Header closeButton>
                    <Modal.Title style={{ color: 'black' }}>Chi tiết Nhóm</Modal.Title>
                  </Modal.Header>
                  <Modal.Body>
                    {selectedGroup && (
                      <div>
                        <p><strong>Group ID:</strong> {selectedGroup.groupId}</p>
                        <p><strong>Total Members:</strong> {selectedGroup.totalMembers}</p>
                      </div>
                    )}
                  </Modal.Body>
                  <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseModal}>Close</Button>
                  </Modal.Footer>
                </Modal> */}
                {/* <Table className="table text-start align-middle table-bordered table-hover mb-0 mt-3">
                  <thead>
                    <tr>
                      <th style={{ fontSize: '16px' }}>ID Group</th>
                      <th style={{ fontSize: '16px' }}>Name Group</th>
                      <th scope="col" style={{ fontSize: '16px' }}>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    {groups.map((group, index) => (
                      <tr key={index} style={{ fontSize: '16px' }}>
                        <td style={{ fontSize: '16px' }}>{group.id}</td>
                        <td style={{ fontSize: '16px' }}>{group.name}</td>
                        <td>
                          {joinedGroups.includes(group.id) ? (
                            <>
                              <button style={{ fontSize: '16px' }} className="btn btn-success mx-3" disabled>
                                Đã tham gia
                              </button>
                              <button style={{ fontSize: '16px' }} className="btn btn-info" onClick={() => fetchBlogsByGroup(group.id)}>
                                Chi tiết
                              </button>
                              
                              <button style={{ fontSize: '16px' }} className="btn btn-danger mx-3" onClick={() => handleLeaveGroup(group.id)}>
                                Thoát nhóm
                              </button>

                            </>
                          ) : (
                            <button style={{ fontSize: '16px' }} className="btn btn-warning mx-3" onClick={() => handleJoinGroup(group.id)}>
                              Tham gia ngay
                            </button>
                          )}
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </Table> */}

                <div className="row">
                {groups.map((group) => (
                  <div className="col-md-6">
                    <div className="recent-game-item" key={group.id}>
                      <div className="rgi-thumb set-bg">
                        <img
                          src={`img/recent-game/2.jpg`}
                          alt="game1"
                        />
                        <div className="cata new"></div>
                      </div>
                      <div className="rgi-content">
                        <h5 style={{marginLeft:'10px'}}>Nhóm: {group.name}</h5>
                 
                        {joinedGroups.includes(group.id) ? (
                            <>
                              {/* <button style={{ fontSize: '16px' }} className="btn btn-success mx-3" disabled>
                                Đã tham gia
                              </button> */}
                              <button style={{ fontSize: '16px' }} className="btn btn-info" onClick={() => fetchBlogsByGroup(group.id)}>
                            Chi tiết
                          </button>
                              <button style={{ fontSize: '16px' }} className="btn btn-danger mx-3" onClick={() => handleLeaveGroup(group.id)}>
                                Thoát nhóm
                              </button>
                            
                            </>
                          ) : (
                            <button style={{ fontSize: '16px' }} className="btn btn-warning mx-3" onClick={() => handleJoinGroup(group.id)}>
                              Tham gia ngay
                            </button>
                          )}
                      </div>
                    </div>
                  </div>
                ))}
              </div>



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
                      <p>Ipsum dolor sit amet, consectetur adipisc ing consecips</p>
                      <a href="#" className="lb-author">By Admin</a>
                    </div>
                  </div>
                  <div className="lb-item">
                    <div className="lb-thumb set-bg">
                      <img src="img/latest-blog/2.jpg" alt="game2" />
                    </div>
                    <div className="lb-content">
                      <div className="lb-date">June 21, 2018</div>
                      <p>Ipsum dolor sit amet, consectetur adipisc ing consecips</p>
                      <a href="#" className="lb-author">By Admin</a>
                    </div>
                  </div>
                  <div className="lb-item">
                    <div className="lb-thumb set-bg">
                      <img src="img/latest-blog/3.jpg" alt="game3" />
                    </div>
                    <div className="lb-content">
                      <div className="lb-date">June 21, 2018</div>
                      <p>Ipsum dolor sit amet, consectetur adipisc ing consecips</p>
                      <a href="#" className="lb-author">By Admin</a>
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
                      <p><a href="#">James Smith</a> <span>on</span> Lorem consec ipsum dolor sit amet, co</p>
                      <div className="tc-date">June 21, 2018</div>
                    </div>
                  </div>
                  <div className="tc-item">
                    <div className="tc-thumb set-bg">
                      <img src="img/authors/2.jpg" alt="person2" />
                    </div>
                    <div className="tc-content">
                      <p><a href="#">Michael James</a> <span>on</span>Cras sit amet sapien aliquam</p>
                      <div className="tc-date">June 21, 2018</div>
                    </div>
                  </div>
                  <div className="tc-item">
                    <div className="tc-thumb set-bg">
                      <img src="img/authors/3.jpg" alt="person3" />
                    </div>
                    <div className="tc-content">
                      <p><a href="#">Justin More</a> <span>on</span> Lorem ipsum dolor consecsit amet, co</p>
                      <div className="tc-date">June 21, 2018</div>
                    </div>
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

export default GroupComponent;
