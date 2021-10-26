package com.epam.brest.autobase.models;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver implements InitAndDestroyBean, Serializable {

    private Integer driver_id;
    private String name;
    private Date dateWhenGotJob;
    private BigDecimal salary;
}
