package com.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.CommentBlogDto;
import com.project.backend.dto.CommentDto;
import com.project.backend.service.CommentBlogService;
import com.project.backend.service.CommentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/commentblog")
@SecurityRequirement(name = "bearerAuth")
public class CommentBlogController {
	 @Autowired
	    private CommentBlogService commentService;
	 
	 @PostMapping("blog/{id}")
	    public ResponseEntity<CommentBlogDto> createComment(@RequestBody CommentBlogDto commentDto, @PathVariable("id") Long blogId){
	        CommentBlogDto savedComment = commentService.createComment(commentDto);
	      
	        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
	    }

	    @PostMapping("{id}")
	    public ResponseEntity<CommentBlogDto> sendComment(@RequestBody CommentBlogDto commentDto,@PathVariable("id") Long blogId){
	        CommentBlogDto savedComment = commentService.sendComment(commentDto, blogId);
	        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);

	    }
	    @GetMapping("blog/{id}")
	    public ResponseEntity<List<CommentBlogDto>> getListComment(@PathVariable("id") Long blogId){
	    	List<CommentBlogDto> comments = commentService.listCommentByBlog(blogId);
	    	return ResponseEntity.ok(comments);
	    }

	    
	    @GetMapping("/{id}")
	    public ResponseEntity<CommentBlogDto> getCommentById(@PathVariable("id") Long commentId){
	        CommentBlogDto comments = commentService.getCommentById(commentId);
	        return ResponseEntity.ok(comments);
	    }


//	    @GetMapping("/findByGame/{id}")
//	    public ResponseEntity<List<CommentBlogDto>> getListCommentByGame(@PathVariable("id") Long gameId){
//	        List<CommentBlogDto> comments = commentService.listCommentByGame(gameId);
//	        return ResponseEntity.ok(comments);
//	    }
//	    @GetMapping("/findByAccount/{id}")
//	    public ResponseEntity<List<CommentBlogDto>> getListCommentByAccount(@PathVariable("id") Long accountId){
//	        List<CommentBlogDto> comments = commentService.listCommentByAccount(accountId);
//	        return ResponseEntity.ok(comments);
//	    }
	    
	    @GetMapping("/findByBlog/{id}")
	    public ResponseEntity<List<CommentBlogDto>> getListCommentByBlog(@PathVariable("id") Long blogId){
	        List<CommentBlogDto> comments = commentService.listCommentByBlog(blogId);
	        return ResponseEntity.ok(comments);
	    }
	    
	    @PutMapping("{id}")
	    public ResponseEntity<CommentBlogDto> updateComment(@RequestBody CommentBlogDto commentDto , @PathVariable("id") Long commentId){
	        CommentBlogDto updatedComment = commentService.updateComment(commentDto,commentId);
	        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	    }

	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId){
	        commentService.deleteComment(commentId);
	        return ResponseEntity.ok("Comment is deleted");
	    }

}
