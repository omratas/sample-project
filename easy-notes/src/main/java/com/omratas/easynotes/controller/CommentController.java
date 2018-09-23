package com.omratas.easynotes.controller;

import com.omratas.easynotes.exception.ResourceNotFoundException;
import com.omratas.easynotes.model.Comment;
import com.omratas.easynotes.repository.CommentRepository;
import com.omratas.easynotes.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/{id}")
    public Page<Comment> getAllCommentsByPostId(@PathVariable(value = "id") String postId, Pageable pageable) {
        return commentRepository.findByPostIdentifier(postId, pageable);
    }

    @PostMapping("/{id}")
    public Comment createComment(@PathVariable(value = "id") String postId, @Valid @RequestBody Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable(value = "postId") String postId,
                                 @PathVariable(value = "commentId") String commentId,
                                 @Valid @RequestBody Comment commentRequest) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("Post", "id", postId);
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId", "id", commentId));
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") String postId,
                                           @PathVariable(value = "commentId") String commentId) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId ", "id", postId);
        }

        return commentRepository.findById(commentId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId ", "id", commentId));
    }
}
