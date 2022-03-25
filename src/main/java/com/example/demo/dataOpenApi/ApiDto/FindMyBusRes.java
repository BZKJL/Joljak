package com.example.demo.dataOpenApi.ApiDto;

import com.example.demo.dataOpenApi.ApiDto.ResponseDto.ApiResponse;
import com.example.demo.dataOpenApi.ApiDto.ResponseDto.BusLocationItem;
import lombok.Data;

@Data
public class FindMyBusRes {
    private ApiResponse<BusLocationItem> response;
}
