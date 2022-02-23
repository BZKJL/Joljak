package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bus {
    private String busNumber;
    private String busId;
    private String beaconId;

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber='" + busNumber + '\'' +
                ", busId='" + busId + '\'' +
                ", beaconId='" + beaconId + '\'' +
                '}';
    }
}
