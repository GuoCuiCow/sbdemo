package com.example.demo.controller;

import com.example.demo.net.NetJsonException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping("/hello")
//    public String index() {
//        return "Hello World";
//    }

    @RequestMapping("/hello")
    public  @ResponseBody
    String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public  @ResponseBody
    String json() throws NetJsonException {
        throw new NetJsonException("发生错误2");
    }

}