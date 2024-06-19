package com.project.backend.service.impl;

import com.project.backend.dto.CommentDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Comment;
import com.project.backend.entity.Game;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.CommentMapper;
import com.project.backend.repository.CommentRepository;
import com.project.backend.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = CommentMapper.MapToComment(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return CommentMapper.MapToCommentDto(savedComment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment is not found" + commentId));
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        comment.setDate(commentDto.getDate());
        comment.setGame(commentDto.getGame());
        comment.setAccount(commentDto.getAccount());
        Comment savedComment = commentRepository.save(comment);
        return CommentMapper.MapToCommentDto(comment);
    }

    @Override
    public List<CommentDto> listComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map((comment) -> CommentMapper.MapToCommentDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment is not found" + commentId));
        return CommentMapper.MapToCommentDto(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
