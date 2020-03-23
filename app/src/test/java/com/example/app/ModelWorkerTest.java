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
import static org.mockito.Mockito.*;

@DisplayName("Model Worker Test")
@ExtendWith(MockitoExtension.class)
public class ModelWorkerTest {

    @Mock private Supplier<Model> modelFactory;
    @Mock private PrintService<Model> printService;
    @InjectMocks private ModelWorker modelWorker;

    @DisplayName("Do job test")
    @Test
    public void doJob() {
        when(modelFactory.get()).thenReturn(
            Model.builder().id(1).build(),
            Model.builder().id(2).build(),
            Model.builder().id(3).build()
        );
        modelWorker.doJob();
        verify(printService, times(1)).print(any(Model.class));
        verify(printService, times(1)).print(anySet());
    }
}