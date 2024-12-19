package com.example.socialmedia.service;

import lombok.Getter;
import lombok.Setter;

public class ResponseObjectiveService {
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private Object payload;
}
