package com.example.interview.service;

import com.example.interview.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SimpleHttpClientService {
    public Response get();
    public Response post(Object body) throws JsonProcessingException;
    public Response put(Object body) throws JsonProcessingException;


}
