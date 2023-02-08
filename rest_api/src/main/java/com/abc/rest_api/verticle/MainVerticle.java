package com.abc.rest_api.verticle;

import com.abc.rest_api.router.UserRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class MainVerticle extends AbstractVerticle {
  private UserRouter userRouter;

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    userRouter = new UserRouter(vertx);
    vertx.createHttpServer().requestHandler(userRouter.getRouter()).listen(8080, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.print("HTTP server started on port 8080");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
