package com.example.interview.service.impl;

import com.example.interview.model.dto.PostDTO;
import com.example.interview.service.HttpClientService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HttpClientServiceImpl implements HttpClientService {
    private final RestTemplate restTemplate;

    public HttpClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PostDTO> get(String url) {
        return Arrays.asList(restTemplate.getForObject(url, PostDTO[].class));
    }

    @Override
    public PostDTO post(String url, PostDTO post) {
        return restTemplate.postForObject(url, post, PostDTO.class);
    }

    @Override
    public PostDTO put(String url, PostDTO body) {
        restTemplate.put(url, body);
        return body;
    }
}
