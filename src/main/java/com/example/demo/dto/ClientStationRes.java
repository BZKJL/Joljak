package com.example.demo.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Data
public class ClientStationRes {
    private int citycode;
    private String nodeid;
    private int nodeno;

    public ClientStationRes(int citycode, String nodeid, int nodeno) {
        this.citycode = citycode;
        this.nodeid = nodeid;
        this.nodeno = nodeno;
    }
}
