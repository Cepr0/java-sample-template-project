package com.example.lib.defaultimpl;

import com.example.lib.model.ModelDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.lib.defaultimpl.TestData.MODEL;
import static com.example.lib.defaultimpl.TestData.MODEL_DTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("ModelMapper Test")
class ModelMapperTest {
    private static final ModelMapper MAPPER = new ModelMapper();

    @DisplayName("Correct mapping")
    @Test
    void map() {
        ModelDto actual = MAPPER.map(MODEL);
        assertThat(actual).isEqualTo(MODEL_DTO);
    }

    @SuppressWarnings("ConstantConditions")
    @DisplayName("IllegalArgumentException when arg is null")
    @Test
    void map_nonNullCheck() {
        assertThatIllegalArgumentException().isThrownBy(() -> MAPPER.map(null));
    }
}