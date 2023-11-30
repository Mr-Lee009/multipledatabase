package com.example.multipledatabase.dto;

import com.example.multipledatabase.model.PageDTO;
import com.example.multipledatabase.model.SortDTO;
import lombok.Data;

@Data
public class RequestDTO<T> {
    private T param;
    private SortDTO sorting;
    private  PageDTO page;
}
