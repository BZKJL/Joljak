package com.example.demo.controller;

import com.example.demo.dto.GPSCoordinateReq;
import com.example.demo.service.ExternalAPIService;
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
    private final ExternalAPIService service;

    @PostMapping()
    public String postGPS(@RequestBody @Valid GPSCoordinateReq req){
        return service.getNearBusStationByGps(req);

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
