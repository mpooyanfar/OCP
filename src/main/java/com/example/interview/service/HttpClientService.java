package com.example.interview.service;


import com.example.interview.model.dto.PostDTO;

import java.util.List;

public interface HttpClientService {
    List<PostDTO> get(String url);
    PostDTO post(String url, PostDTO body);
    PostDTO put(String url, PostDTO body);
}
