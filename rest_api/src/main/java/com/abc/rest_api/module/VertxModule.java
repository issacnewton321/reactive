package com.abc.rest_api.module;

import io.vertx.core.Vertx;

public class VertxModule {
  private Vertx vertx;
  private static VertxModule INSTANCE;
  private VertxModule () {
    vertx = Vertx.vertx();
  }
  public static VertxModule getInstance () {
    if (INSTANCE == null) {
      INSTANCE = new VertxModule();
    }
    return INSTANCE;
  }
  public Vertx vertx() {
    return vertx;
  }
}
