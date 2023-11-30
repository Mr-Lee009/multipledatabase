package com.example.multipledatabase.dto;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilderDTO {
    public ResponseBuilderDTO() {

    }

    public <T> ResponseDTO<T> success(T body) {
        ResponseDTO<T> response = new ResponseDTO<>();
        response.setStatus(Status.SUCCESS);
        response.setMessage("");
        response.setBody(body);
        return response;
    }

}
