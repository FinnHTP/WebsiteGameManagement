package com.project.backend.service;

import com.project.backend.dto.CommentDto;
import com.project.backend.entity.Comment;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto updateComment(CommentDto commentDto , Long commentId);
    List<CommentDto> listComment();
    CommentDto getCommentById(Long commentId);
    void deleteComment(Long commentId);
}
