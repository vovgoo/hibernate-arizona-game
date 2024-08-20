package org.example.mapper;

public interface Mapper <F,T> {

    T mapFrom(F object);

    F mapTo(T object);
}
