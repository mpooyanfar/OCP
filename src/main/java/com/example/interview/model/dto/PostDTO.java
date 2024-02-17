package com.example.interview.model.dto;

import lombok.Data;

@Data
public class PostDTO {
    Long id;
    Long userId;
    String title;
    String body;
}
