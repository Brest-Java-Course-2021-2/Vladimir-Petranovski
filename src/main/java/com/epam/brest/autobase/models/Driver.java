package com.epam.brest.autobase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    private Long id;
    private String name;
    private Date dateWhenGotJob;
    private Double salary;
}
