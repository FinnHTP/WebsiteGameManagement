package com.project.backend.controller;

import com.project.backend.dto.CommentDto;
import com.project.backend.dto.ReactionDto;
import com.project.backend.dto.ThrowReactionDTO;
import com.project.backend.service.CommentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/reaction")
@SecurityRequirement(name = "bearerAuth")
public class ReactionController {
	@Autowired
   private  CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity<ThrowReactionDTO> addReaction(@RequestBody ThrowReactionDTO throwReactionDTO) {
       commentService.addReaction(throwReactionDTO);
       return new ResponseEntity<>(throwReactionDTO, HttpStatus.CREATED);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Long> getReactionsByCommentId(@PathVariable("id") Long commentId) {
        Long reaction = commentService.getReactionsByCommentId(commentId);
        return ResponseEntity.ok(reaction);
    }
    @GetMapping("test")
    public ResponseEntity<String> test(){
    	return ResponseEntity.ok("hello");
    }
 
}
