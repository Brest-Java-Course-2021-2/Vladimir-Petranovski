package com.epam.brest.motor_depot.models;

import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver implements InitAndDestroyBean, Serializable {

    private Integer driver_id;
    private String name;
    private Date dateStartWork;
    private BigDecimal salary;
}
