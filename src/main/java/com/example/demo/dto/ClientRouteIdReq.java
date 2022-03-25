package com.example.demo.dto;

import lombok.Data;


@Data
public class ClientRouteIdReq {
    private String bus;
    private int citycode;
    private String nodeid;
    private int nodeno;
}

