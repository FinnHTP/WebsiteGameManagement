package com.project.backend.mapper;

import com.project.backend.dto.BlogDto;
import com.project.backend.dto.DepositDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.entity.Blog;
import com.project.backend.entity.Deposit;
import com.project.backend.entity.Group;

public class BlogMapper {
	
	   public static Blog mapToEntity(BlogDto BlogDto){
	        Blog bl = new Blog();
	        bl.setId(BlogDto.getId());
	        bl.setAccount(BlogDto.getAccount());
	        bl.setGroup((BlogDto.getGroup()));
	        bl.setContent(BlogDto.getContent());
	        bl.setCreateDate(BlogDto.getCreateDate());
	        bl.setStatus(BlogDto.getStatus());
	        bl.setGame(BlogDto.getGame());
	        return bl;
	    }

	    public static BlogDto mapToDTO(Blog blog){
	        BlogDto blogDto = new BlogDto();
	        blogDto.setId(blog.getId());
	        blogDto.setAccount(blog.getAccount());
	        blogDto.setGroup(blog.getGroup());
	        blogDto.setCreateDate(blog.getCreateDate());
	        blogDto.setContent(blog.getContent());
	        blogDto.setStatus(blog.getStatus());
	        blogDto.setGame(blog.getGame());
	        return blogDto;
	    }
}
