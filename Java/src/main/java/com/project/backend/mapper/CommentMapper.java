package com.project.backend.mapper;


import com.project.backend.dto.CommentDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Comment;
import com.project.backend.entity.Game;
import com.project.backend.repository.CommentRepository;

public class CommentMapper {
    public static CommentDto MapToCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setAccount(comment.getAccount());
        commentDto.setContent(comment.getContent());
        commentDto.setDate(comment.getDate());
        commentDto.setParentId(comment.getParentId());
        commentDto.setGame(comment.getGame());
        return commentDto;
    }

    public static Comment MapToComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setAccount(commentDto.getAccount());
        comment.setContent(commentDto.getContent());
        comment.setDate(commentDto.getDate());
        comment.setParentId(commentDto.getParentId());
        comment.setGame(commentDto.getGame());
        return comment;
    }

}
