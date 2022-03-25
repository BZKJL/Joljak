/*
package com.example.demo.controller;

import com.example.demo.dataOpenApi.DataOpenApiService;
import com.example.demo.dto.ClientRouteIdReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
class RouteAPIControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    DataOpenApiService dataOpenApiService;


    @Test
    @DisplayName("[200] post api")
    void name1() throws Exception {
        ClientRouteIdReq bus = new ClientRouteIdReq("16");
        mvc.perform(MockMvcRequestBuilders.post("/api/route")
                        .queryParam("busId","16")
                        .contentType("application/json")
                        .accept("application/json"))

                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("[400] post api")
    void name222() throws Exception {
        ClientRouteIdReq bus = new ClientRouteIdReq("16");
        mvc.perform(MockMvcRequestBuilders.post("/api/route")
                        .content(mapper.writeValueAsString(bus))
                        .contentType("application/json")
                        .accept("application/json"))

                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}
*/
