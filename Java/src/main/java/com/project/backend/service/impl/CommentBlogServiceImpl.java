package com.project.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.backend.dto.CommentBlogDto;
import com.project.backend.dto.CommentDto;
import com.project.backend.entity.Comment;
import com.project.backend.entity.CommentBlog;
import com.project.backend.entity.Game;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.CommentBlogMapper;
import com.project.backend.mapper.CommentMapper;
import com.project.backend.repository.CommentBlogRepository;
import com.project.backend.repository.CommentRepository;
import com.project.backend.service.CommentBlogService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentBlogServiceImpl implements CommentBlogService {

	private CommentBlogRepository commentBlogRepository;

	   @Override
	    public CommentBlogDto sendComment(CommentBlogDto commentDto, Long gameId) {
	        Game game = new Game();
	        game.setId(gameId);
	        CommentBlog comment = CommentBlogMapper.mapToCommentBlog(commentDto);
	        comment.setGame(game);
	        CommentBlog savedComment = commentBlogRepository.save(comment);
	        return CommentBlogMapper.MapToCommentBlogDto(savedComment);
	    }

	   @Override
	    public CommentBlogDto createComment(CommentBlogDto commentDto) {
	        CommentBlog comment = CommentBlogMapper.mapToCommentBlog(commentDto);
	        CommentBlog savedComment = commentBlogRepository.save(comment);
	        return CommentBlogMapper.MapToCommentBlogDto(savedComment);
	    }

	   @Override
	    public CommentBlogDto updateComment(CommentBlogDto commentDto, Long commentId) {
	        CommentBlog comment = commentBlogRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment is not found" + commentId));
	        comment.setId(commentDto.getId());
	        comment.setContent(commentDto.getContent());
	        comment.setDate(commentDto.getDate());
	        comment.setGame(commentDto.getGame());
	        comment.setAccount(commentDto.getAccount());
	        CommentBlog savedComment = commentBlogRepository.save(comment);
	        return CommentBlogMapper.MapToCommentBlogDto(comment);
	    }

//	   @Override
//	    public List<CommentBlogDto> listCommentByGame(Long gameId) {
//	        List<CommentBlog> comments = commentBlogRepository.findByGame(gameId);
//	        return comments.stream().map((comment) -> CommentBlogMapper.MapToCommentBlogDto(comment)).collect(Collectors.toList());
//	    }



//	   @Override
//		public List<CommentBlogDto> listCommentByAccount(Long account) {
//			// TODO Auto-generated method stub
//	        List<CommentBlog> comments = commentBlogRepository.findByAccount(account);
//	        return comments.stream().map((comment) -> CommentBlogMapper.MapToCommentBlogDto(comment)).collect(Collectors.toList());
//			
//		}

	@Override
	public List<CommentBlogDto> listCommentByBlog(Long blog) {
		  List<CommentBlog> comments = commentBlogRepository.findByBlog(blog);
	        return comments.stream().map((comment) -> CommentBlogMapper.MapToCommentBlogDto(comment)).collect(Collectors.toList());
	}

	   @Override
	    public CommentBlogDto getCommentById(Long commentId) {
	        CommentBlog comment = commentBlogRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment is not found" + commentId));
	        return CommentBlogMapper.MapToCommentBlogDto(comment);
	    }

	    @Override
	    public void deleteComment(Long commentId) {
	        commentBlogRepository.deleteById(commentId);
	    }

		@Override
		public List<CommentBlogDto> listComment() {
			// TODO Auto-generated method stub
			return null;
		}


}
