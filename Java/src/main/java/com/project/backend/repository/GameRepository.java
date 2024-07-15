package com.project.backend.repository;

import com.project.backend.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "SELECT TOP 8 * FROM games", nativeQuery = true)
    List<Game> findTop8Game();
    
    @Query(value = "SELECT g.name AS game_name, SUM(od.price) AS total_price " +
            "FROM games g " +
            "JOIN orderdetails od ON g.id = od.game_id " +
            "GROUP BY g.name", nativeQuery = true)
    List<Object[]> getMonthlyStatistics();


    
    
//    Theo game ko có nam
   
 
//    @Query(value = "SELECT g.name AS game_name, SUM(od.price) AS total_price " +
//            "FROM games g " +
//            "JOIN orderdetails od ON g.id = od.game_id " +
//            "JOIN orders o ON od.order_id = o.id " +
//            "WHERE YEAR(o.date) = :year " +
//            "GROUP BY g.name", nativeQuery = true)
//List<Object[]> getTotalRevenueByGame(@Param("year") int year);
}
