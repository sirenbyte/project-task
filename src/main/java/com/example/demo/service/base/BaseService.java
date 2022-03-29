package com.example.demo.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> extends Serializable {
    T save(T t);

    T edit(T t);

    void delete(ID id);

    void delete(T t);

    Optional<T> find(ID id);

    List<T> getAll();

    T findOrThrow(ID id);
}
