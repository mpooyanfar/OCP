package com.example.interview.controller;

import com.example.interview.model.Response;
import com.example.interview.model.dto.PostDTO;
import com.example.interview.model.dto.UpdateDTO;
import com.example.interview.service.PostApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    This class has provided HttpClient for real api
 */
@RestController
public class ApiController {

    private final PostApiService postApiService;

    @Autowired
    public ApiController(PostApiService httpClient) {
        this.postApiService = httpClient;
    }


    @GetMapping("/data")
    public Response fetchData(){
        var response = postApiService.get();
        return new Response(0,
                "the operation was successful",
                response);
    }

    @PostMapping("/data")
    public Response postData(@RequestBody PostDTO post) {
        var response = postApiService.post(post);
        return new Response(0,
                "the operation was successful",
                response);
    }

    @PutMapping("/data/{id}")
    public Response updateData(@RequestBody UpdateDTO post, @PathVariable Long id){
        var response = postApiService.put(post, id);
        return new Response(0,
                "the operation was successful",
                response);
    }

}
