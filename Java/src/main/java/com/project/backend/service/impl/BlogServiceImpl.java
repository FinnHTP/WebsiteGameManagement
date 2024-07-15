package com.project.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.dto.BlogDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.entity.Blog;
import com.project.backend.entity.Group;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.BlogMapper;
import com.project.backend.mapper.GroupMapper;
import com.project.backend.repository.BlogRepository;
import com.project.backend.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	BlogRepository blogRepository;

	@Override
	public BlogDto createBlog(BlogDto Dto) {
		 Blog blog = BlogMapper.mapToEntity(Dto);
		 Blog savedBlog = blogRepository.save(blog);
		 return BlogMapper.mapToDTO(savedBlog);
	}

	@Override
	public BlogDto getBlogById(Long blogId) throws ResourceNotFoundException {
	    Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog is not found with " + blogId));
	    return BlogMapper.mapToDTO(blog);
	}

	@Override
	public List<BlogDto> getAll() {
	    List<Blog> blogs = blogRepository.findAll();
	    return blogs.stream().map((blog) -> BlogMapper.mapToDTO(blog)).collect(Collectors.toList());
	}

	@Override
	public BlogDto Update(Long blogId, BlogDto updatedDto) {
	   Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog is not found with " + blogId));
	//   group.setId(updatedDto.getId());
	    blog.setContent(updatedDto.getContent());
	    blog.setStatus(updatedDto.getStatus());
	    Blog saved = blogRepository.save(blog);
	    return BlogMapper.mapToDTO(saved);
	}

	@Override
	public void deleteBlog(Long blogId) {
	    Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog is not found with " + blogId));
	    blogRepository.delete(blog);
	}

	@Override
	public List<Blog> findBlogInGroup(Long groupId) {
		// TODO Auto-generated method stub
		return blogRepository.findBlogInGroup(groupId);
	}

	@Override
	public List<Blog> findBlogByAccount(Long accountId) {
		// TODO Auto-generated method stub
		return blogRepository.findBlogByAccount(accountId);
	}

	@Override
	public List<Blog> findBlogByGame(Long gameId) {
		return blogRepository.findBlogByGame(gameId);
	}
	
	
	
	
}
