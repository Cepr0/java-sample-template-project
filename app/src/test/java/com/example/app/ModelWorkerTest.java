package com.example.app;

import com.example.lib.PrintService;
import com.example.lib.model.Model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Supplier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.verify;

@DisplayName("Model Worker Test")
@ExtendWith(MockitoExtension.class)
public class ModelWorkerTest {

    @Mock private Supplier<Model> modelFactory;
    @Mock private PrintService<Model> printService;
    @InjectMocks private ModelWorker modelWorker;

    @DisplayName("Do job test")
    @Test
    public void doJob() {
        modelWorker.doJob();
        verify(printService).print(any(Model.class));
        verify(printService).print(anySet());
    }
}