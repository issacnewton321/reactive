package com.abc.rest_api.router;

import com.abc.rest_api.entity.User;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.ArrayList;
import java.util.List;

public class UserRouter2 {
  private Router router;
  private final String URL_PREFIX = "/user2";
  private Vertx vertx;

  private List<User> listUser = new ArrayList<>();

  public UserRouter2(Vertx vertx) {
    router = Router.router(vertx);
    this.vertx = vertx;
  }

  public Router getRouter() {
    router.route().handler(BodyHandler.create());
    router.get(URL_PREFIX).handler(ctx -> {
      ctx.json(listUser);
    });

    router.post(URL_PREFIX).consumes("*/json").handler(ctx -> {
      JsonObject requestBody = ctx.body().asJsonObject();
//      try {
//        Thread.sleep(1000);
//        System.out.println("\n========================");
//        System.out.println("execute");
//
//        System.out.println(requestBody);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//      User user = requestBody.mapTo(User.class);
//        listUser.add(user);
//      System.out.println("done!");
//      System.out.println("==========================\n");
//      System.out.println("************************************************************************************");
//        ctx.json(JsonObject.mapFrom(user));
//    });

      System.out.println("Number of active threads from the given thread: " + Thread.currentThread().getId());
      vertx.setTimer(2000, done -> {
        System.out.println("\n========================");
        System.out.println("execute");

        System.out.println(requestBody);
        User user = requestBody.mapTo(User.class);
        listUser.add(user);
        System.out.println("done!");
        System.out.println("==========================\n");
        System.out.println("************************************************************************************");
        ctx.json(JsonObject.mapFrom(user));
      });

    });
    return router;
  }
}
