package com.mcmanus.court.api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@Builder
public class Court {

    @Id
    private Integer id;
    private String name;
    private String city;
    private Double latitude;
    private Double longitude;

}
