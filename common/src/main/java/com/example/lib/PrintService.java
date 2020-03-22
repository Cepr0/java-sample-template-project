package com.example.lib;

import java.util.Collection;

public interface PrintService<T> {
    void print(T model);
    void print(Collection<T> models);
}
