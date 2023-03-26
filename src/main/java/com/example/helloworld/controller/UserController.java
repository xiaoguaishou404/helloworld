package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "Hello World, User ID: " + id;
    }

    @PostMapping("/user")
    public String save(User user) {
        return "添加用户成功";
    }

    @PutMapping("/user")
    public String update(User user) {
        return "更新用户成功";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id) {
        return "删除用户成功";

    }

}
