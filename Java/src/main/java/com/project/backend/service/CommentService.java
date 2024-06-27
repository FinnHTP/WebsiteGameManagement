package com.project.backend.service;

import java.util.List;

import com.project.backend.dto.CommentDto;

public interface CommentService {
    CommentDto sendComment(CommentDto commentDto , Long gameId);
    CommentDto createComment(CommentDto commentDto);
    CommentDto updateComment(CommentDto commentDto , Long commentId);
    List<CommentDto> listComment();
    List<CommentDto> listCommentByGame(Long gameId);
    List<CommentDto> listCommentByAccount(Long account);
    CommentDto getCommentById(Long commentId);
    void deleteComment(Long commentId);
}
