package com.example.demo.service;

import com.example.demo.dto.GPSCoordinateReq;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class ExternalAPIServiceTest {

    @Test
    void name() {

        RestTemplate rest = new RestTemplate();
        String API_SERVICE_KEY = "OSsqksel6JSVbZDK+DpRzUJMPzeHMRUOrqysyrIxSOfyQSYEv82iDk+e72rzXSRHcJZ34UBYb4xAEL75bpzFEw==";
        String URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList?serviceKey=" + API_SERVICE_KEY + "&gpsLati=36.3&gpsLong=127.3&numOfRows=10&pageNo=1&_type=xml";

        String response = rest.getForObject(URL, String.class);

        System.out.println(response);
    }

    @Test
    void name2() {
        String API_SERVICE_KEY = "OSsqksel6JSVbZDK+DpRzUJMPzeHMRUOrqysyrIxSOfyQSYEv82iDk+e72rzXSRHcJZ34UBYb4xAEL75bpzFEw==";
        String GET_STATION_BY_GPS = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";
        HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) Unirest.get(GET_STATION_BY_GPS)
                .queryString("serviceKey",API_SERVICE_KEY)
                .queryString("gpsLati",36.3)
                .queryString("gpsLong",127.3)
                .queryString("_type","json")
                .asJson();

        assertThat(response.getStatus()).isEqualTo(200);
    }
}
