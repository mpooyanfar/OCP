package com.example.interview.controller;

import com.example.interview.model.Response;
import com.example.interview.model.dto.UpdateDTO;
import com.example.interview.service.impl.HttpClientServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/*
    This class has provided HttpClient for real api,
    you can use this fake url :https://jsonplaceholder.typicode.com/posts

 */
@RestController
public class ApiController {

    private final HttpClientServiceImpl httpClient;

    @Autowired
    public ApiController(HttpClientServiceImpl httpClient) {
        this.httpClient = httpClient;
    }


    @GetMapping("/data")
    public Response fetchData(@RequestParam String url) throws JsonProcessingException {
        var response = httpClient.get(url);
        ObjectMapper objectMapper = new ObjectMapper();
        return new Response(0,
                "the operation was successful",
                objectMapper.readTree(response));
    }

    @PostMapping("/data")
    public Response postData(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        String url = (String) requestData.get("url");
        Map<String, Object> body = (Map<String, Object>) requestData.get("body");

        var response = httpClient.post(url, body.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        return new Response(0,
                "the operation was successful",
                objectMapper.readTree(response));
    }

/*
    note that you must add an id to the fake url like this :
     -> https://jsonplaceholder.typicode.com/posts/1
 */

    @PutMapping("/data")
    public Response updateData(@RequestBody UpdateDTO updateDTO) throws JsonProcessingException {
        var response = httpClient.put(updateDTO.getUrl(), updateDTO.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        return new Response(0,
                "the operation was successful",
                objectMapper.readTree(response));
    }

}
