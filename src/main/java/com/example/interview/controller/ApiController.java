package com.example.interview.controller;

import com.example.interview.model.Response;
import com.example.interview.model.dto.PostDTO;
import com.example.interview.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    This class has provided HttpClient for real api
 */
@RestController
public class ApiController {

    private final HttpClientService httpClient;

    @Autowired
    public ApiController(HttpClientService httpClient) {
        this.httpClient = httpClient;
    }


    @GetMapping("/data")
    public Response fetchData(){
        var response = httpClient.get("https://jsonplaceholder.typicode.com/posts");
        return new Response(0,
                "the operation was successful",
                response);
    }

    @PostMapping("/data")
    public Response postData(@RequestBody PostDTO post) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        var response = httpClient.post(url, post);
        return new Response(0,
                "the operation was successful",
                response);
    }

    @PutMapping("/data")
    public Response updateData(@RequestBody PostDTO post){
        var response = httpClient.put("https://jsonplaceholder.typicode.com/posts/1", post);
        return new Response(0,
                "the operation was successful",
                response);
    }

}
