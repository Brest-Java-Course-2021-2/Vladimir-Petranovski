package com.epam.brest.autobase.models;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver implements IInitAndDestroyBean, Serializable {

    private Integer id;
    private String name;
    private Date dateWhenGotJob;
    private BigDecimal salary;
}
