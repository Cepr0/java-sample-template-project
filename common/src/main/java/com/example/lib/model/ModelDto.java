package com.example.lib.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@ToString(of = {"id", "name"})
@Value
public class ModelDto {
    private int id;
    private String name;
    private String address;
    private Location location;

    @Value
    public static class Location {
        private double latitude;
        private double longitude;
    }
}
