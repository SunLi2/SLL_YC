package com.zsc.wxapp.controller;

import com.zsc.wxapp.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 以JSON格式返回数据
@RequestMapping("/api/wxapp/test")
public class testController {

    //前端测试
    @GetMapping("/test_get")   //测试连接：http://localhost:8080/api/test_get
    public Result test_get() {

        return Result.ok("get请求测试成功","我是get测试数据！");

    }
    @PostMapping("/test_post")  //测试连接：http://localhost:8080/api/test_post
    public Result test_post() {

        return Result.ok("post请求测试成功","我是post测试数据！");
    }


    @PostMapping("/sendSms")  //测试连接：http://localhost:8080/api/test_post
    public Result sendSms() {

        return Result.ok("post请求测试成功","我是post测试数据！");
    }
}
