package com.example.interview.service;


public interface HttpClientService {
    String get(String url);
    String post(String url, String body);
    String put(String url, Object body);
}
