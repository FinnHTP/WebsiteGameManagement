package com.project.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.BlogDto;
import com.project.backend.entity.Blog;
import com.project.backend.service.BlogService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/blogs")
@SecurityRequirement(name = "bearerAuth")
public class BlogController {

	private BlogService blogService;
	
	
	 @GetMapping
	    public ResponseEntity<List<BlogDto>> getAll(){
	        List<BlogDto> blogs = blogService.getAll();
	        return ResponseEntity.ok(blogs);
	    }
	 
	 @GetMapping("{id}")
	    public ResponseEntity<BlogDto> getBlogById(@PathVariable("id") Long blogId){
	        BlogDto blogDto = blogService.getBlogById(blogId);
	        return ResponseEntity.ok(blogDto);
	    }
	 
//	 @GetMapping("/{groupid}/{id}")
//	    public ResponseEntity<List<Blog>> getBloginGroup(@PathVariable("id") Long blogId, @PathVariable("groupid") Long groupId){
//	        List<Blog> blogDto = blogService.findBlogInGroup(groupId);
//	        return ResponseEntity.ok(blogDto);
//	    }
	 

	    @GetMapping("/group/{groupId}")
	    public ResponseEntity<List<Blog>> getBlogsByGroup(@PathVariable("groupId") Long groupId) {
	        List<Blog> blogs = blogService.findBlogInGroup(groupId);
	        return ResponseEntity.ok(blogs);
	    }
	 
	 
}
