package com.example.controller;

import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.common.Result;
import com.example.service.LoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * @Author: suragi
 * @Date: 2024/12/23 20:21
 * @Description: 处理登录相关逻辑
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        log.info("用户登录请求: {}", loginRequest);
        LoginResponse response = loginService.login(loginRequest);
        log.info("用户登录成功: {}", response);
        return Result.success(response);
    }

    @PostMapping("/logout")
    public Result<String> logout(){
        log.info("用户登出请求");
        return Result.success("ok");
    }

    @PostMapping("/refresh")
    public Result<LoginResponse> refresh(){
        log.info("刷新token请求");
        return Result.success(new LoginResponse());
    }
}

