package com.abc.rest_api.verticle;

import com.abc.rest_api.router.UserRouter;
import com.abc.rest_api.router.UserRouter2;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class SubVerticle extends AbstractVerticle {
    private UserRouter2 userRouter;
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        userRouter = new UserRouter2(vertx);
        vertx.createHttpServer().requestHandler(userRouter.getRouter()).listen(8080, http -> {
        if (http.succeeded()) {
            startPromise.complete();
            System.out.println("HTTP server 2 started on port 8080");
        } else {
            startPromise.fail(http.cause());
        }
        });
}
    
}
