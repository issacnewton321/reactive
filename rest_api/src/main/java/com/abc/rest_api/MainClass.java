package com.abc.rest_api;

import com.abc.rest_api.module.VertxModule;
import com.abc.rest_api.verticle.MainVerticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class MainClass {
  private final Vertx vertx = VertxModule.getInstance().vertx();
  public static void main(String[] args) {

    MainClass mainClass = new MainClass();
    // deploy verticle
    mainClass.vertx.deployVerticle(new MainVerticle());
  }
}
