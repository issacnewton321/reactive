package com.abc.rest_api.router;

import com.abc.rest_api.entity.User;
import com.abc.rest_api.module.VertxModule;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.ArrayList;
import java.util.List;

public class UserRouter {
  private Router router;
  private final String URL_PREFIX = "/user";
  private Vertx vertx;

  private List<User> listUser = new ArrayList<>();

  public UserRouter(Vertx vertx) {
    router = Router.router(vertx);
    this.vertx = vertx;
  }

  public Router getRouter() {
    // init web client
    WebClient client = WebClient.create(vertx);

    router.route().handler(BodyHandler.create());
    router.get(URL_PREFIX).handler(ctx -> {
      ctx.json(listUser);
    });

    router.post(URL_PREFIX).consumes("*/json").handler(ctx -> {
      JsonObject requestBody = ctx.body().asJsonObject();
System.out.println("Number of active threads from the given thread: " + Thread.currentThread().getName());
            
        System.out.println("\n========================");
        System.out.println("execute");

        System.out.println(requestBody);
        User user = requestBody.mapTo(User.class);
        listUser.add(user);
        System.out.println("done!");
        System.out.println("==========================\n");
        System.out.println("************************************************************************************");
        
        //ctx.json(user);
      // call delay client 
      client.get(8085,"localhost", "/delay")
      .send()
      .onSuccess(res -> {
         ctx.json(user);
      })
      .onFailure(err -> {
        System.out.println("Error when call delay service : " + err.getMessage());
      });


     
    });
  return router;
  }
}
