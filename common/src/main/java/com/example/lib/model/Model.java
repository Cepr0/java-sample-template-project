package com.example.lib.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@ToString(of = {"id", "name"})
@Value
public class Model {
    private int id;
    private String name;
    private String city;
    private String street;
    private String number;
    private double latitude;
    private double longitude;
}
