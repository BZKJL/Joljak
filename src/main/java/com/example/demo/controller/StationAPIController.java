package com.example.demo.controller;

import com.example.demo.dataOpenApi.DataOpenApiService;
import com.example.demo.dataOpenApi.ApiDto.GPSCoordinateReq;
import com.example.demo.dataOpenApi.ApiDto.GPSCoordinateRes;
import com.example.demo.dto.ClientStationReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        value = "/api/station",
        produces = MediaType.APPLICATION_JSON_VALUE
)

public class StationAPIController {
    private final DataOpenApiService dataOpenApiService;
    public GPSCoordinateRes gpsCoordinateRes;
    @PostMapping()
    public String postGPS(@RequestBody @Valid ClientStationReq gps){
        GPSCoordinateReq gpsCoordinateReq = new GPSCoordinateReq(gps);
        gpsCoordinateRes = dataOpenApiService.getNearBusStationByGps(gpsCoordinateReq);
        return gpsCoordinateRes.toString();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse exception(HttpMessageNotReadableException e){

        return ErrorResponse.with404("Not Found");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exception(RuntimeException e){

        return ErrorResponse.with500("internal server error");
    }



}
