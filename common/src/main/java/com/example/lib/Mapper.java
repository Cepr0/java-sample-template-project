package com.example.lib;

@FunctionalInterface
public interface Mapper<S, T> {
    T map(S source);
}