package com.example.helloworld.controller;

import com.example.helloworld.entity.Order;
import com.example.helloworld.entity.User;
import com.example.helloworld.mapper.OrderMapper;
import com.example.helloworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/order")
    public List getOrderList() {
        List<Order> list = orderMapper.selectAllOrdersAndUser();
        return list;
    }
}
