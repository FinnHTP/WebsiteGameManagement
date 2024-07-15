package com.project.backend.mapper;


import com.project.backend.dto.CommentBlogDto;
import com.project.backend.dto.CommentDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Comment;
import com.project.backend.entity.CommentBlog;
import com.project.backend.entity.Game;
import com.project.backend.repository.CommentRepository;

public class CommentBlogMapper {
    public static CommentBlogDto MapToCommentBlogDto(CommentBlog comment){
        CommentBlogDto commentDto = new CommentBlogDto();
        commentDto.setId(comment.getId());
        commentDto.setAccount(comment.getAccount());
        commentDto.setContent(comment.getContent());
        commentDto.setDate(comment.getDate());
        commentDto.setParentId(comment.getParentId());
        commentDto.setGame(comment.getGame());
        commentDto.setBlog(comment.getBlog());
        return commentDto;
    }

    public static CommentBlog mapToCommentBlog(CommentBlogDto commentDto){
        CommentBlog comment = new CommentBlog();
        comment.setId(commentDto.getId());
        comment.setAccount(commentDto.getAccount());
        comment.setContent(commentDto.getContent());
        comment.setDate(commentDto.getDate());
        comment.setParentId(commentDto.getParentId());
        comment.setGame(commentDto.getGame());
        comment.setBlog(commentDto.getBlog());
        return comment;
    }

}
