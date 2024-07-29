import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Card, Row, Col, Container, Pagination } from 'react-bootstrap';
import { jwtDecode } from "jwt-decode";

const FavoriteComponent = () => {
  const [favorites, setFavorites] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [gameId, setGameId] = useState(0);
  const[idFavorite, setidFavorite] = useState(0);
  const itemsPerPage = 2;

  useEffect(() => {
    ListAllFavorites();
  }, []);


  const ListAllFavorites = async () => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.error("Không có token được tìm thấy");
      return;
    }

    try {
      const response = await axios.get("http://localhost:8080/api/favorites/isactive", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      setFavorites(response.data);
    } catch (error) {
      console.error("Lỗi khi gửi yêu cầu:", error);
    }
  };

  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = favorites.slice(indexOfFirstItem, indexOfLastItem);

  const totalPages = Math.ceil(favorites.length / itemsPerPage);

  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber);
  };



  const unLike = async (favoriteId) => {
    const token = localStorage.getItem("accesstoken");
    if (!token) {
      console.error("Token Not Found");
      return;
    }

    try {
      await axios.put(
        `http://localhost:8080/api/favorites/${favoriteId}/unlike`,
        {},
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

     
      setFavorites(favorites.filter(favorite => favorite.id !== favoriteId));
      console.log("Removed from favorites successfully");
    } catch (error) {
      console.error("Lỗi khi bỏ yêu thích", error);
    }
  };



  return (
    <Container>
        <h6 className="h6-infor-user">My favorite</h6>
      <p style={{ marginLeft: "15px" }}>
        Display information about the games you was liked.
      </p>
      <hr style={{color:'black'}}></hr>
      <Row>
        {currentItems.map((favorite, index) => (
          <Col key={index} sm={12} md={6} lg={5} className="mb-4" style={{marginLeft:'25px', marginTop:'0px'}}>
            <Card>
              <Card.Body>
                <Card.Title style={{color:'white'}}>{favorite.game.name}</Card.Title>
                <img style={{width:'200px', height:'150px', marginLeft:'15px'}}  src={`/img/recent-game/${favorite.game.image}`}  />
                <Card.Text style={{color:'#dcdcdc'}}>{favorite.game.description}</Card.Text>
                <Card.Text style={{color:'#dcdcdc'}} ><strong style={{color:'#dcdcdc'}} >Price: </strong>{favorite.game.priceGame}</Card.Text>
                <button className='btn btn-warning' style={{marginLeft:'170px', marginTop:'-30px'}} onClick={() => unLike(favorite.id)} >Unlike</button>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
      <Pagination style={{marginLeft :'40%'}}>
        {[...Array(totalPages).keys()].map((number) => (
          <Pagination.Item
            key={number + 1}
            active={number + 1 === currentPage}
            onClick={() => handlePageChange(number + 1)}
          >
            {number + 1}
          </Pagination.Item>
        ))}
      </Pagination>
    </Container>
  );
};

export default FavoriteComponent;
