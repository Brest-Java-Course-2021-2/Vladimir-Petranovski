package com.epam.brest.autobase.models;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements InitAndDestroyBean, Serializable {

    private Integer id;
    private String model;
    private Boolean isServiceable;
    private Integer driver_id;
}
