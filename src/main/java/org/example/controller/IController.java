package org.example.controller;

import io.javalin.http.Context;
import org.example.exception.ApiException;

public interface IController<T, D> {
    void read(Context ctx) throws ApiException;
    void readAll(Context ctx);
    void create(Context ctx);
    void update(Context ctx);
    void delete(Context ctx);
}
