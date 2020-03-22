package com.example.app;

import com.example.lib.PrintService;
import com.example.lib.model.Model;

import java.util.Set;
import java.util.function.Supplier;

final class ModelWorker {
    private final Supplier<Model> modelFactory;
    private final PrintService<Model> printService;

    ModelWorker(Supplier<Model> modelFactory, PrintService<Model> printService) {
        this.modelFactory = modelFactory;
        this.printService = printService;
    }

    void doJob() {
        printService.print(modelFactory.get());
        printService.print(Set.of(
                modelFactory.get(),
                modelFactory.get()
        ));
    }
}
