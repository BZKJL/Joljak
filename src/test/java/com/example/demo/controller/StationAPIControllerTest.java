package com.example.demo.controller;

import com.example.demo.dto.GPSCoordinateReq;
import com.example.demo.service.ExternalAPIService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StationAPIController.class)
class StationAPIControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ExternalAPIService service;

    @Test
    @DisplayName("[200] external api called")
    void name0() throws Exception {
        GPSCoordinateReq obj = new GPSCoordinateReq(37.3, 127.3);
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString(obj))
                        .contentType("application/json"))
                    .andDo(print())
                    .andExpect(status().isOk());


        verify(service).getNearBusStationByGps(obj);
    }

    @Test
    @DisplayName("[200] is ok")
    void name() throws Exception {
        GPSCoordinateReq obj = new GPSCoordinateReq(37.3, 127.3);
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString(obj))
                        .contentType("application/json"))
                    .andDo(print())
                    .andExpect(status().isOk());

    }
    @Test
    @DisplayName("[500] internal server error")
    void name1() throws Exception {
        GPSCoordinateReq obj = new GPSCoordinateReq(37.3, 127.3);
        doThrow(new RuntimeException("500")).when(service).getNearBusStationByGps(obj);
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString(obj))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isInternalServerError());

    }

    @Test
    @DisplayName("[400] latitude가 null일 경우")
    void name2() throws Exception {
        GPSCoordinateReq obj = new GPSCoordinateReq(null, 127.3);
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString(obj))
                        .contentType("application/json"))
                    .andDo(print())
                    .andExpect(status().isBadRequest());

    }
    @Test
    @DisplayName("[400] longtude가 null일 경우")
    void name3() throws Exception {
        GPSCoordinateReq obj = new GPSCoordinateReq(37.3, null);
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString(obj))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("[400] 둘 다 null일 경우")
    void name4() throws Exception {
        GPSCoordinateReq obj = new GPSCoordinateReq(null, null);
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString(obj))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("[404] Not Found")
    void name5() throws Exception {
        mvc.perform(post("/api/station")
                        .content(mapper.writeValueAsString("{}"))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

}
