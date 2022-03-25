package com.example.demo.dataOpenApi.ApiDto;

import com.example.demo.dataOpenApi.ApiDto.ResponseDto.ApiResponse;
import com.example.demo.dataOpenApi.ApiDto.ResponseDto.StationItem;
import lombok.Data;

@Data
public class StationListRes {
    private ApiResponse<StationItem> response;
}
