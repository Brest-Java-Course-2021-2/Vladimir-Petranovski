package com.epam.brest.autobase.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    private Long id;
    private String name;
    private Driver driver;

}
