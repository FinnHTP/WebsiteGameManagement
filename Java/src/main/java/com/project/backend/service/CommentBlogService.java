package com.project.backend.service;

import java.util.List;

import com.project.backend.dto.CommentBlogDto;
import com.project.backend.dto.CommentDto;

public interface CommentBlogService {

	 CommentBlogDto sendComment(CommentBlogDto commentDto , Long gameId);
	 CommentBlogDto createComment(CommentBlogDto commentDto);
	    CommentBlogDto updateComment(CommentBlogDto commentDto , Long commentId);
	    List<CommentBlogDto> listComment();
//	    List<CommentBlogDto> listCommentByGame(Long gameId);
//	    List<CommentBlogDto> listCommentByAccount(Long account);
	    List<CommentBlogDto> listCommentByBlog(Long blog);
	    CommentBlogDto getCommentById(Long commentId);
	    void deleteComment(Long commentId);
}
