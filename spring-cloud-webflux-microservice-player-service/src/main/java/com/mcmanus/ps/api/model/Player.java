package com.mcmanus.ps.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id @GeneratedValue
    private int id;
    private String firstname;
    private String name;
    private int level;
    private String mail;

}
