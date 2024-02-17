package com.example.interview.service.impl;

import com.example.interview.model.dto.PostDTO;
import com.example.interview.model.dto.UpdateDTO;
import com.example.interview.service.PostApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PostApiServiceImpl implements PostApiService {
    private final RestTemplate restTemplate;

    @Value("${post.url}")
    private String url;

    public PostApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PostDTO> get() {
        return Arrays.asList(restTemplate.getForObject(url, PostDTO[].class));
    }

    @Override
    public PostDTO post(PostDTO post) {
        return restTemplate.postForObject(url, post, PostDTO.class);
    }

    @Override
    public UpdateDTO put(UpdateDTO body, Long id) {
        restTemplate.put(url+"/"+id, body);
        return body;
    }
}
