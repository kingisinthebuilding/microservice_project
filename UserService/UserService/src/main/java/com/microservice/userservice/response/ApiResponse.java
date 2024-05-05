package com.microservice.userservice.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ApiResponse
{
    private String message;
    private boolean success;
    private HttpStatus status;
}
