package com.epam.brest.autobase.models;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request implements IInitAndDestroyBean, Serializable {

    private Integer id;
    private String name;
    private Integer driver_id;

}
