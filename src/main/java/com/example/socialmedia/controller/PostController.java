package com.example.socialmedia.controller;


import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.PostBody;
import com.example.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    private Post post;

    // Create a new post
    @PostMapping("/upload")
    public Post createPost(@RequestBody PostBody postBody) {
        post = new Post(postBody.getContent());
        return postService.createPost(post);
    }

    // Get all posts
    /*@GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }*/

    // Get logged user posts
    @GetMapping("/myposts")
    public List<Post> getMyPosts() {
        String myUsername;
        // Get username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
        myUsername = authentication.getName(); // This will return the username
        }
        else {
            myUsername = null;
        }

        return postService.getAllPosts(myUsername);
    }

   /* // Get a post by ID
    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }*/

    // Get a post by user
    @GetMapping("/{user}")
    public List<Post> getPostByUser(@PathVariable String user) {
        return postService.getAllPosts(user);
    }

    // Update a post
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post postDetails) {
        return postService.updatePost(id, postDetails);
    }

    // Delete a post
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id) {
        postService.deletePost(id);
    }
}