package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation(value="获取用户列表", notes="不需要传参")
    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @ApiOperation(value="获取用户信息", notes="根据用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public  User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        User one = userRepository.getOne(id);
        System.out.println("user.name="+one.getName());
        return one;
    }

}
