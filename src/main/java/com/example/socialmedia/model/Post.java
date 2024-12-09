package com.example.socialmedia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String content;
    private String user;
    private LocalDateTime createdAt;

    public Post(String content, String user) {
        this.content = content;
        this.user = user;
        this.createdAt = LocalDateTime.now();

        // Generate ID
        long timestamp = createdAt.atZone(
                ZoneId.systemDefault().systemDefault()).toInstant().toEpochMilli();
        this.id = user + "_" + timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}