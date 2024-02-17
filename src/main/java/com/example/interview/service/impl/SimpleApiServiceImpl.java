package com.example.interview.service.impl;

import com.example.interview.model.Response;
import com.example.interview.service.SimpleApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


@Service
public class SimpleApiServiceImpl implements SimpleApiService {
    @Override
    public Response get() {
        return new Response(0,
                "the operation was Successful",
                "get");
    }

    @Override
    public Response post(Object body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJson = objectMapper.writeValueAsString(body);

        return new Response(0,
                "the operation was Successful",
                objectMapper.readTree(bodyJson));
    }

    @Override
    public Response put(Object body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJson = objectMapper.writeValueAsString(body);

        return new Response(0,
                "the operation was Successful",
                objectMapper.readTree(bodyJson));
    }

}
