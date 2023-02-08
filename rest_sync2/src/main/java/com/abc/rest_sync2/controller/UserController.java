package com.abc.rest_sync2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.rest_sync2.entity.User;
import com.google.gson.Gson;

@RestController()
@RequestMapping("/user")
public class UserController {
    private List<User> listUser = new ArrayList<>();
    @GetMapping("/") 
    public List<User> getAll() {
        return listUser;
    }

    @PostMapping("/")
    public User addUser (@RequestBody @Validated User user) throws InterruptedException {
        System.out.println("number of active threads from the given thread: " + Thread.currentThread().getId());
        Thread.sleep(2000);
        
        System.out.println("\n========================");
        System.out.println("execute");

        listUser.add(user);
        System.out.println(new Gson().toJson(user));
        System.out.println("done!");
        System.out.println("==========================\n");
        System.out.println("*************************************************");
        
       return user;
    }
}
