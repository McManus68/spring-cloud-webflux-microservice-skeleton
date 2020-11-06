package com.mcmanus.player.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Court {

    private Integer id;
    private String name;
    private String city;
    private Double latitude;
    private Double longitude;

}
