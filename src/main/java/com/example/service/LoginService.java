package com.example.service;

import com.example.common.CustomUserDetails;
import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.common.RefreshResponse;

public interface LoginService {
    /**
     * 用户登录
     */
    LoginResponse login(CustomUserDetails userDetails, LoginRequest loginRequest);

    /**
     * 由有效的RefreshToken刷新AccessToken
     */
    RefreshResponse refreshToken(String refreshToken);

    /**
     * 用户登出
     */
    void logout();
}
