package com.omratas.easynotes.controller;

import com.omratas.easynotes.exception.ResourceNotFoundException;
import com.omratas.easynotes.model.Post;
import com.omratas.easynotes.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable(value = "id") Long id, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(id).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setContent(postRequest.getContent());
            post.setDescription(postRequest.getDescription());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long id) {
        return postRepository.findById(id).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }
}
