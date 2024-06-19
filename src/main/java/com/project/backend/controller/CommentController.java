package com.project.backend.controller;

import com.project.backend.dto.CommentDto;
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
@RequestMapping("/api/comment")
@SecurityRequirement(name = "bearerAuth")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto){
        CommentDto savedComment = commentService.createComment(commentDto);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CommentDto>> getListComment(){
        List<CommentDto> comments = commentService.listComment();
        return ResponseEntity.ok(comments);
    }

    @PutMapping("{id}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto , @PathVariable("id") Long commentId){
        CommentDto updatedComment = commentService.updateComment(commentDto,commentId);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment is deleted");
    }

}
