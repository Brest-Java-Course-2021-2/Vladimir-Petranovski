package com.epam.brest.autobase.models;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Request implements IInitAndDestroyBean, Serializable {

    private Integer id;
    private String name;
    private Integer driver_id;

    public Request() {
    }

    public Request(Integer id, String name, Integer driver_id) {
        this.id = id;
        this.name = name;
        this.driver_id = driver_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) && Objects.equals(name, request.name) && Objects.equals(driver_id, request.driver_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, driver_id);
    }
}
