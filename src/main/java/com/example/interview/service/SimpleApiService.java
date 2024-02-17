package com.example.interview.service;

import com.example.interview.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SimpleApiService {
    Response get();
    Response post(Object body) throws JsonProcessingException;
    Response put(Object body) throws JsonProcessingException;

}
