package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Paper {

    private Integer id;
    private String name;
    private LocalDate startDate;
    private Integer fee;

    public Paper(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("data") LocalDate startDate, @JsonProperty("fee") Integer fee) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.fee = fee;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}
