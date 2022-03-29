package com.example.demo.util;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class clz, Object obj) {
        super(String.format("Entity %s not found by id : %s", clz, obj));
    }
}
