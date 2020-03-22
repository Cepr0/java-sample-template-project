package com.example.lib.defaultimpl;

import com.example.lib.Mapper;
import com.example.lib.model.Model;
import com.example.lib.model.ModelDto;
import lombok.NonNull;

import java.util.StringJoiner;

public class ModelMapper implements Mapper<Model, ModelDto> {
    @Override
    public ModelDto map(@NonNull Model model) {
        String address = new StringJoiner(", ")
                .add(model.getCity())
                .add(model.getStreet())
                .add(model.getNumber())
                .toString();

        return ModelDto.builder()
                .id(model.getId())
                .name(model.getName())
                .address(address)
                .location(new ModelDto.Location(model.getLatitude(), model.getLongitude()))
                .build();
    }
}
