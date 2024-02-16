package com.example.interview.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@NoArgsConstructor
public class Response {
    private int responseCode = 0;
    private static final int BadArgument = 1000;
    private static final int genericError = 1001;

    private String message = "";
    private Object response = Map.of();

    public Response (int responseCode, String message) {
        this(responseCode, message, Map.of());
    }

    public Response(int responseCode, String message, Object response) {
        this.responseCode = responseCode;
        this.message = message;
        this.response = response;
    }
}
