package com.example.multipledatabase.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {
    private T body;
    private String message;
    private Status status;
}
