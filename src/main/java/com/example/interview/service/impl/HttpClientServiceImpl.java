package com.example.interview.service.impl;

import com.example.interview.service.HttpClientService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientServiceImpl implements HttpClientService {
    private final RestTemplate restTemplate;

    public HttpClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String post(String url, String body) {
        return restTemplate.postForObject(url, body, String.class);
    }

    @Override
    public String put(String url, Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class).getBody();
    }
}
