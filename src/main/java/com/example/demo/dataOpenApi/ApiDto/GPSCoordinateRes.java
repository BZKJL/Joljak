package com.example.demo.dataOpenApi.ApiDto;

import com.example.demo.dataOpenApi.ApiDto.ResponseDto.ApiResponse;
import com.example.demo.dataOpenApi.ApiDto.ResponseDto.NearBusStationItem;
import lombok.Data;

@Data
public class GPSCoordinateRes {
    private ApiResponse<NearBusStationItem> response;
}

