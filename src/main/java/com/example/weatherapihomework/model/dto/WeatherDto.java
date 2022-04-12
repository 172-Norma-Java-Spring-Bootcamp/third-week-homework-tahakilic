package com.example.weatherapihomework.model.dto;

import lombok.Data;

@Data
public class WeatherDto {

    private Request request;
    private Location location;
    private Current current;


}


