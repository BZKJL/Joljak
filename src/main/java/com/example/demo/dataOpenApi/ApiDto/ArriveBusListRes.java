package com.example.demo.dataOpenApi.ApiDto;

import com.example.demo.dataOpenApi.ApiDto.ResponseDto.ApiResponse;
import com.example.demo.dataOpenApi.ApiDto.ResponseDto.ArriveBusItem;
import lombok.Data;

@Data
public class ArriveBusListRes {
    private ApiResponse<ArriveBusItem> response;
}
