package com.example.socialmedia.repository;

import com.example.socialmedia.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByUser(String user);

}