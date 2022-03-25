package com.example.demo.controller;


import com.example.demo.dataOpenApi.ApiDto.*;
import com.example.demo.dataOpenApi.ApiDto.ResponseDto.BusLocationItem;
import com.example.demo.dataOpenApi.ApiDto.ResponseDto.StationItem;
import com.example.demo.dataOpenApi.DataOpenApiService;
import com.example.demo.dto.ClientRouteIdRes;
import com.example.demo.dto.ClientStationRes;
import com.example.demo.dto.ClientRouteIdReq;
import com.example.demo.dto.ClientStationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class ApiController {
    private final DataOpenApiService dataOpenApiService;


    @GetMapping("/station")
    public ClientStationRes getStation(@RequestBody @Valid ClientStationReq gps){
        GPSCoordinateReq gpsCoordinateReq = new GPSCoordinateReq(gps);
        GPSCoordinateRes gpsCoordinateRes = dataOpenApiService.getNearBusStationByGps(gpsCoordinateReq);
        ClientStationRes result = new ClientStationRes(gpsCoordinateRes.getResponse().getBody().getItems().getItem().get(1).getCitycode(),
                gpsCoordinateRes.getResponse().getBody().getItems().getItem().get(0).getNodeid(),
                gpsCoordinateRes.getResponse().getBody().getItems().getItem().get(0).getNodeno());
        return result;
    }



    @GetMapping("/routeId")
    public ClientRouteIdRes getRouteId(@RequestBody @Valid ClientRouteIdReq clientRouteIdReq){
        RouteReq routeReq = new RouteReq(clientRouteIdReq);
        RouteRes routeRes = dataOpenApiService.getRouteIdByBusNo(routeReq);
        String routeid = routeRes.getResponse().getBody().getItems().getItem().getRouteid();//오픈소스: 루트 아이디 받아오기
        log.info("RouteId = {}",routeid);


        StationListReq stationListReq = new StationListReq(routeid,clientRouteIdReq.getCitycode());
        StationListRes stationListRes = dataOpenApiService.getStationListByRouteId(stationListReq);
        List<StationItem> stationList = stationListRes.getResponse().getBody().getItems().getItem(); //정류소 목록 조회

        int nodeord = 0;

        for(StationItem item : stationList){
            if( clientRouteIdReq.getNodeno() == item.getNodeno()){
                nodeord = item.getNodeord();
            }
        } // 현재 정류장의 순서를 정류장 목록에서 조회 후 nodeord에 저장 >> 도착정보에서 사용함.

        ArriveBusListReq arriveBusListReq = new ArriveBusListReq(clientRouteIdReq.getNodeid(),clientRouteIdReq.getCitycode(),routeid);
        ArriveBusListRes arriveBusListRes = dataOpenApiService.getArriveByStationAndBusNo(arriveBusListReq);

        int findord = nodeord - arriveBusListRes.getResponse().getBody().getItems().getItem().get(0).getArrprevstationcnt();
        FindMyBusReq findMyBusReq = new FindMyBusReq(clientRouteIdReq.getCitycode(),routeid);
        FindMyBusRes findMyBusRes = dataOpenApiService.getLocationByBusNo(findMyBusReq);
        List<BusLocationItem> busLocationItems = findMyBusRes.getResponse().getBody().getItems().getItem();

        String vehicleno = "";

        for(BusLocationItem item : busLocationItems){
            if(findord == item.getNodeord()){
                vehicleno = item.getVehicleno();

            }
        }


        ClientRouteIdRes result = new ClientRouteIdRes(routeid+vehicleno.substring(5,8));
        return result;
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
