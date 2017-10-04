package com.chhaichivon.springbootrxjava.models;


import javax.persistence.Entity;

/**
 * @author by chhai.chivon  on 10/3/2017.
 */
@Entity
public class Category {
    private String name;
    private String descriptio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public void setDescriptio(String descriptio) {
        this.descriptio = descriptio;
    }
}
