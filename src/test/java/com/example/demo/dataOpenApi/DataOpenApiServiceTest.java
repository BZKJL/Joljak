/*
package com.example.demo.dataOpenApi;

import com.example.demo.dto.ApiDto.ResponseDto.NearBusStationItem;
import com.example.demo.dto.ApiDto.RouteReq;
import com.example.demo.dto.ClientRouteIdReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
class DataOpenApiServiceTest {

    @Autowired
    DataOpenApiService dataOpenApiService;


//    @Test
//    public void name(){
//        var gps = new GPSCoordinateReq(new UserGps(37.375017,126.63296));
//        var result = dataClient.getNearBusStationByGps(gps);
//        System.out.println(result);
//    }
//
   @Test
  void name1() {
       ClientRouteIdReq bus = new ClientRouteIdReq("16");
       NearBusStationItem nearBusStationItem = new NearBusStationItem(23, 126.634827, 37.373141, "ICB164000376", "인천대학교공과대학", 38376);
       var routeReq = new RouteReq(bus, nearBusStationItem);
      var result = dataOpenApiService.getRouteIdByBusNo(routeReq);
      System.out.println(result);
      Assertions.assertThat(result.getResponse()).isNotNull();
   }

}


*/
