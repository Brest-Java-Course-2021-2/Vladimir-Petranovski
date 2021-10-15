package com.epam.brest.autobase.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id;
    private String model;
    private Boolean isServiceable;
    private Driver driver;
}
