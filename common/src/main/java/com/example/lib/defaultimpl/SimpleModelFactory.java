package com.example.lib.defaultimpl;

import com.example.lib.model.Model;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import lombok.NonNull;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SimpleModelFactory implements Supplier<Model> {

    private final Supplier<Integer> generator;
    private final Faker faker;

    public SimpleModelFactory(@NonNull Supplier<Integer> generator, @NonNull Faker faker) {
        this.generator = generator;
        this.faker = faker;
    }

    @Override
    public Model get() {
        Address address = faker.address();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return Model.builder()
                .id(generator.get())
                .name(faker.funnyName().name())
                .city(address.city())
                .street(address.streetName())
                .number(address.streetAddressNumber())
                .latitude(random.nextDouble(10.0, 50.0))
                .longitude(random.nextDouble(0.0, 180.0))
                .build();
    }
}
