package com.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.backend.entity.CommentBlog;


public interface CommentBlogRepository extends JpaRepository<CommentBlog,Long>{
    @Query("select o from CommentBlog o where o.game.id = ?1")
   List<CommentBlog> findByGame(Long gameId);

@Query("select o from CommentBlog o where o.account.id = ?1")
List<CommentBlog> findByAccount(Long accountId);

@Query("select o from CommentBlog o where o.blog.id = ?1")
List<CommentBlog> findByBlog(Long blogId );
}
