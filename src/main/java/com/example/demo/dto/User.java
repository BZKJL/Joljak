package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String Uid;
    private String locatex;
    private String locatey;
    private String busstop;

    @Override
    public String toString() {
        return "User{" +
                "Uid='" + Uid + '\'' +
                ", locatex='" + locatex + '\'' +
                ", locatey='" + locatey + '\'' +
                ", busstop='" + busstop + '\'' +
                '}';
    }
}
