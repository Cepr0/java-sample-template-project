package com.example.lib.defaultimpl;

import com.example.lib.model.Model;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.FunnyName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Supplier;

import static com.example.lib.defaultimpl.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("SimpleModelFactory Test")
@ExtendWith(MockitoExtension.class)
class SimpleModelFactoryTest {

    @Mock private Supplier<Integer> generator;
    @Mock private Faker faker;
    @InjectMocks private SimpleModelFactory modelFactory;

    @DisplayName("Correct Model creation")
    @Test
    void get() {
        Address address = mock(Address.class);
        when(faker.address()).thenReturn(address);

        FunnyName funnyName = mock(FunnyName.class);
        when(faker.funnyName()).thenReturn(funnyName);

        when(generator.get()).thenReturn(ID);
        when(address.city()).thenReturn(CITY);
        when(address.streetName()).thenReturn(STREET);
        when(address.streetAddressNumber()).thenReturn(NUMBER);
        when(funnyName.name()).thenReturn(NAME);

        Model actual = modelFactory.get();

        assertThat(actual).satisfies(model -> {
            assertThat(model.getId()).isEqualTo(ID);
            assertThat(model.getCity()).isEqualTo(CITY);
            assertThat(model.getStreet()).isEqualTo(STREET);
            assertThat(model.getNumber()).isEqualTo(NUMBER);
            assertThat(model.getName()).isEqualTo(NAME);
        });
    }

    @DisplayName("Ctor args must not be null")
    @Test
    void ctor_withNullArgs() {
        assertThatIllegalArgumentException().isThrownBy(() -> new SimpleModelFactory(null, faker));
        assertThatIllegalArgumentException().isThrownBy(() -> new SimpleModelFactory(generator, null));
    }
}