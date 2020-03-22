package com.example.lib.defaultimpl;

import com.example.lib.Mapper;
import com.example.lib.PrintService;
import com.example.lib.model.Model;
import com.example.lib.model.ModelDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ModelPrintService implements PrintService<Model> {

    private final Mapper<Model, ModelDto> modelMapper;
    private final ObjectWriter jsonPrinter;

    public ModelPrintService(@NonNull Mapper<Model, ModelDto> modelMapper, @NonNull ObjectMapper objectMapper) {
        this.modelMapper = modelMapper;
        jsonPrinter = objectMapper.writerWithDefaultPrettyPrinter();
    }

    @SneakyThrows
    @Override
    public void print(Model model) {
        ModelDto modelDto = modelMapper.map(model);
        String json = jsonPrinter.writeValueAsString(modelDto);
        System.out.printf("Model DTO: %n%s%n", json);
        log.debug("Model has been printed: {}", model);
    }

    @SneakyThrows
    @Override
    public void print(Collection<Model> models) {
        Set<ModelDto> modelDtos = models.stream().map(modelMapper::map).collect(Collectors.toSet());
        System.out.printf("%nModel DTOs: %n%s%n", jsonPrinter.writeValueAsString(modelDtos));
        log.debug("Models has been printed: {}", models);
    }
}
