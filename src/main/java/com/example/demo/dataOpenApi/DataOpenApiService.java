package com.example.demo.dataOpenApi;

import com.example.demo.dataOpenApi.ApiDto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class DataOpenApiService {

    @Value("${data.serviceKey}")
    private String dataClientId;

    public GPSCoordinateRes getNearBusStationByGps(GPSCoordinateReq gpsCoordinateReq){
        String GET_STATION_BY_GPS = "http://apis.data.go.kr";
        String PATH ="/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";
        var uri = UriComponentsBuilder
                .fromHttpUrl(GET_STATION_BY_GPS+PATH)
                .queryParam("serviceKey",dataClientId)
                .queryParams(gpsCoordinateReq.toMultiValueMap())
                .build(true)
                .toUri();


        log.info("1.GPSCoordinateRes");

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<GPSCoordinateRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }
    public RouteRes getRouteIdByBusNo(RouteReq routeReq){
        String GET_ROUTE_ID = "http://apis.data.go.kr";
        String PATH ="/1613000/BusRouteInfoInqireService/getRouteNoList";
        var uri = UriComponentsBuilder
                .fromHttpUrl(GET_ROUTE_ID+PATH)
                .queryParam("serviceKey",dataClientId)
                .queryParams(routeReq.toMultiValueMap())
                .build(true)
                .toUri();

        log.info("2.RouteRes");

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<RouteRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        log.info("before return");
        return responseEntity.getBody();

    }
    public StationListRes getStationListByRouteId(StationListReq stationListReq){
        String GET_STATION_LIST = "http://apis.data.go.kr";
        String PATH ="/1613000/BusRouteInfoInqireService/getRouteAcctoThrghSttnList";
        var uri = UriComponentsBuilder
                .fromHttpUrl(GET_STATION_LIST+PATH)
                .queryParam("serviceKey",dataClientId)
                .queryParams(stationListReq.toMultiValueMap())
                .build(true)
                .toUri();

        log.info("3.StationListRes");

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<StationListRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }

    public ArriveBusListRes getArriveByStationAndBusNo(ArriveBusListReq arriveBusListReq){
        String GET_STATION_LIST = "http://apis.data.go.kr";
        String PATH ="/1613000/ArvlInfoInqireService/getSttnAcctoSpcifyRouteBusArvlPrearngeInfoList";
        var uri = UriComponentsBuilder
                .fromHttpUrl(GET_STATION_LIST+PATH)
                .queryParam("serviceKey",dataClientId)
                .queryParams(arriveBusListReq.toMultiValueMap())
                .build(true)
                .toUri();

        log.info("4.ArriveBusListRes");

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<ArriveBusListRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }
    public FindMyBusRes getLocationByBusNo(FindMyBusReq findMyBusReq){
        String GET_BUS_STATION = "http://apis.data.go.kr";
        String PATH ="/1613000/BusLcInfoInqireService/getRouteAcctoBusLcList";
        var uri = UriComponentsBuilder
                .fromHttpUrl(GET_BUS_STATION+PATH)
                .queryParam("serviceKey",dataClientId)
                .queryParams(findMyBusReq.toMultiValueMap())
                .build(true)
                .toUri();

        log.info("5.FindMyBusRes");

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<FindMyBusRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        log.info("before return");
        return responseEntity.getBody();

    }

}
