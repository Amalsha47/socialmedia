package com.example.socialmedia.service;

import com.example.socialmedia.model.Post;
import com.example.socialmedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Create a new post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get post by ID
    public Optional<Post> getPostById(String id) {
        return postRepository.findById(id);
    }

    // Update post
    public Post updatePost(String id, Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setContent(postDetails.getContent());
        post.setUser(postDetails.getUser());
        return postRepository.save(post);
    }

    // Delete post
    public void deletePost(String id) {
        postRepository.deleteById(id);
    }
}
