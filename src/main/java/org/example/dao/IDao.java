package org.example.dao;

import org.example.exception.ApiException;

import java.util.List;

public interface IDao<T, D> {
    T read(D d) throws ApiException;
    List<T> readAll();
    T create(T t) throws ApiException;
    T update(D d, T t) throws ApiException;
    void delete(D d) throws ApiException;
}