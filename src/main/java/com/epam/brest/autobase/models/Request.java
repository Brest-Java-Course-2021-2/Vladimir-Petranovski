package com.epam.brest.autobase.models;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request implements InitAndDestroyBean, Serializable {

    private Integer request_id;
    private String name;
    private Integer driver_id;

}
