package com.example.lib.defaultimpl;

import com.example.lib.model.Model;
import com.example.lib.model.ModelDto;

import static com.example.lib.defaultimpl.ModelMapper.DELIMITER;

public class TestData {
    public static final int ID = 1;
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String NUMBER = "number";
    public static final String NAME = "name";
    public static final double LATITUDE = 1.0;
    public static final double LONGITUDE = 2.0;

    public static final Model MODEL = Model.builder()
            .id(ID)
            .name(NAME)
            .city(CITY)
            .street(STREET)
            .number(NUMBER)
            .latitude(LATITUDE)
            .longitude(LONGITUDE)
            .build();

    public static final ModelDto MODEL_DTO = ModelDto.builder()
            .id(ID)
            .name(NAME)
            .address(CITY + DELIMITER + STREET + DELIMITER + NUMBER)
            .location(ModelDto.Location.of(LATITUDE, LONGITUDE))
            .build();
}
