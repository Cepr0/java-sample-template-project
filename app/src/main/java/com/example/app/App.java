package com.example.app;

import com.example.lib.PrintService;
import com.example.lib.defaultimpl.ModelMapper;
import com.example.lib.defaultimpl.ModelPrintService;
import com.example.lib.defaultimpl.SimpleModelFactory;
import com.example.lib.model.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        var generator = new AtomicInteger();
        Supplier<Model> modelFactory = new SimpleModelFactory(generator::incrementAndGet, new Faker());
        PrintService<Model> printService = new ModelPrintService(new ModelMapper(), new ObjectMapper());
        ModelWorker modelWorker = new ModelWorker(modelFactory, printService);
        modelWorker.doJob();
    }
}
