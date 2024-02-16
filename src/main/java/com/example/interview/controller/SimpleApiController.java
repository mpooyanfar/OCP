package com.example.interview.controller;

import com.example.interview.model.Response;
import com.example.interview.service.SimpleHttpClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SimpleApiController {
    private final SimpleHttpClientService service;

    public SimpleApiController(SimpleHttpClientService service) {
        this.service = service;
    }

    @GetMapping("/client")
    public Response getMethod(){
        return service.get();
    }

    @PostMapping("/client")
    public Response postMethod(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        Map<String, Object> body = (Map<String, Object>) requestData.get("body");
        if (body == null) {
            throw new RuntimeException("It can not fetch the body from the json");
        }
        return service.post(body);
    }

    @PutMapping("/client/{id}")
    public Response putMethod(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        Map<String, Object> body = (Map<String, Object>) requestData.get("body");
        if (body == null) {
            throw new RuntimeException("It can not fetch the body from the json");
        }
        return service.put(body);
    }
}
