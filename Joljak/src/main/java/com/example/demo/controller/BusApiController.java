package com.example.demo.controller;

import com.example.demo.dto.Bus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusApiController {

    @PostMapping("/buspost")
    public String PostBus(){
        return "posted!";
    }
    @GetMapping("/businfo")
    public Bus SearchBus(@RequestBody Bus bus){
        return bus;
    }
}
