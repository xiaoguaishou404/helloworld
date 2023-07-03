package com.example.helloworld.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloworld.entity.User;
import com.example.helloworld.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> getUserList() {
        List<User> list = userMapper.selectAllUserAndOrders();
        return list;
    }

    @GetMapping("/userQuery/{username}")
    public List<User> getUserListByQuery(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/userPage")
    public IPage getUserPageList() {
        Page<User> page = new Page<>(1, 2);
        IPage iPage = userMapper.selectPage(page, null);
        return iPage;
    }

    @ApiOperation("获取用户")
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userMapper.selectById(id);
    }

    @PostMapping("/user")
    public String save(User user) {
        int successNum = userMapper.insert(user);
        System.out.println(user);
        if (successNum > 0) {
            return "success";
        } else {
            return "fail";
        }
    }


}


//@RestController
//public class UserController {
//    @Autowired
//    private UserMapper userMapper;
//
//    @GetMapping("/user")
//    public List getUserList() {
////      List<User> list = userMapper.selectList("user");
//        return list;
//    }
//
//    @ApiOperation("获取用户")
//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable int id) {
//        return userMapper.selectById(id);
//    }
//
//    @PostMapping("/user")
//    public String save(User user) {
//        int successNum = userMapper.insert(user);
//        if (successNum > 0) {
//            return "success";
//        } else {
//            return "fail";
//        }
//    }
//
//    @PutMapping("/user")
//    public int update(User user) {
//        return userMapper.update(user);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public int deleteById(@PathVariable int id) {
//        return userMapper.delete(id);
//    }
//
//}
