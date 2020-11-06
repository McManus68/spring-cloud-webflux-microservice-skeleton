package com.mcmanus.player.api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@Builder
public class Player {

    @Id
    private Integer id;
    private String name;
    private String mail;
    private Integer level;
    private Integer favoriteCourt;
}
