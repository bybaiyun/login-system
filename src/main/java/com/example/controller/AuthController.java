package com.example.controller;

import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * @Author: suragi
 * @Date: 2024/12/23 20:21
 * @Description: 处理登录相关逻辑
 */
@RestController("/auth")
public class AuthController {
    @PostMapping("/login")
    public Result<LoginResponse> login(LoginRequest loginRequest){
        return Result.success(new LoginResponse());
    }

    @PostMapping("/logout")
    public Result<String> logout(){
        return Result.success("ok");
    }

    @PostMapping("/refresh")
    public Result<LoginResponse> refresh(){
        return Result.success(new LoginResponse());
    }
}

