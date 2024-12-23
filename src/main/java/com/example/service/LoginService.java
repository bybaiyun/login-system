package com.example.service;

import com.example.common.LoginRequest;
import com.example.common.LoginResponse;

public interface LoginService {
    /**
     * 用户登录
     */
    LoginResponse login(LoginRequest request);

    /**
     * 刷新token
     */
    LoginResponse refreshToken(String refreshToken);

    /**
     * 用户登出
     */
    void logout(String accessToken);

    /**
     * 检查token是否有效
     */
    boolean checkToken(String jwtToken);
}
