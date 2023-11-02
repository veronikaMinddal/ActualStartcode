package org.example.exception;

import org.example.routes.Routes;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandler
{
    public void apiExceptionHandler(ApiException e, Context ctx) {
        ctx.status(e.getStatusCode());
        ctx.json(new Message(e.getStatusCode(), e.getMessage()));
    }
    public void exceptionHandler(Exception e, Context ctx) {
        ctx.status(500);
        ctx.json(new Message(500, e.getMessage()));
    }
}