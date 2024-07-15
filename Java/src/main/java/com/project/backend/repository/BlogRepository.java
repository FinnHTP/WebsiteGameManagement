package com.project.backend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.backend.entity.Blog;


public interface BlogRepository extends JpaRepository<Blog,Long> {
	    @Query("select o from Blog o where o.group.id = ?1")
	   List<Blog> findBlogInGroup(Long groupId);

   @Query("select o from Blog o where o.account.id = ?1")
   List<Blog> findBlogByAccount(Long accountId);
   
   @Query("select o from Blog o where o.game.id = ?1")
   List<Blog> findBlogByGame(Long accountId);
}
