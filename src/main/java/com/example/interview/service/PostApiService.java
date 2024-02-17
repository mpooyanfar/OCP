package com.example.interview.service;


import com.example.interview.model.dto.PostDTO;
import com.example.interview.model.dto.UpdateDTO;

import java.util.List;

public interface PostApiService {
    List<PostDTO> get();
    PostDTO post(PostDTO body);
    UpdateDTO put(UpdateDTO body, Long id);
}
