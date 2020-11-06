package com.mcmanus.ps.api.common;

import lombok.Data;

@Data
public class Court {

    private Integer id;
    private String name;
    private String city;
    private Double latitude;
    private Double longitude;

}
