package com.project.backend.repository;

import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "SELECT TOP 8 * FROM games", nativeQuery = true)
    List<Game> findTop8Game();
   // List<GameDto> findByOrderId(Long orderId);
//   @Query("SELECT g FROM Game g JOIN g.orderdetails od WHERE od.order.id = :orderId")
//   List<GameDto> findByOrderId(@Param("orderId") Long orderId);
   @Query("SELECT od.game FROM OrderDetail od WHERE od.order.id = :orderId")
   Game getOrderGameByOrderId(@Param("orderId") Long orderId);


    @Query("SELECT g.image FROM Game g WHERE g.id = :gameId")
    String findImageById(@Param("gameId") Long gameId);

}
