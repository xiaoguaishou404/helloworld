package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return "get";
    }

    @RequestMapping(value = "/get-query", method = RequestMethod.GET)
    public String getQuery(String name, @RequestParam(value = "id", defaultValue = "1") String id, @RequestParam(value = "age", required = false) String size) {
        return "get-query  " + name + id + size;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String postQuery(String name, String id) {
        System.out.println(id);
        return "post-query  " + name + id;
    }

    @RequestMapping(value = "/post-classFormUrlencoded", method = RequestMethod.POST)
    public String postClassFormUrlencoded(User user) {
        System.out.println(user);
        return "post-query  " + user;
    }

    @RequestMapping(value = "/post-classJson", method = RequestMethod.POST)
    public String postClassJson(@RequestBody User user) {
        System.out.println(user);
        return "post-query  " + user;
    }


}
