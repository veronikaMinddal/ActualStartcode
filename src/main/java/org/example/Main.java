package org.example;


import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.routes.Routes;
import org.example.config.ApplicationConfig;
import org.example.exception.ExceptionHandler;
import org.example.exception.ApiException;
import org.example.exception.Message;
public class Main {
    private static final Routes routes = new Routes();
    private static final Javalin app = Javalin.create();
    private static final ExceptionHandler EXCEPTION_HANDLER = new ExceptionHandler();
    private static int count = 0;

    private static void requestInfoHandler(Context ctx) {
        String requestInfo = ctx.req().getMethod() + " " + ctx.req().getRequestURI();
        ctx.attribute("requestInfo", requestInfo);
    }

    public static void main(String[] args) {

        app.before(Main::requestInfoHandler);
        app.updateConfig(ApplicationConfig::configuration);

        app.routes(routes.getRoutes(app));

        app.exception(ApiException.class, EXCEPTION_HANDLER::apiExceptionHandler);
        app.exception(Exception.class, EXCEPTION_HANDLER::exceptionHandler);

        app.start(7071);
    }
}