package com.example.service.impl;

import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.service.LoginService;

/**
 * @Author: suragi
 * @Date: 2024/12/23 20:41
 * @Description:
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public LoginResponse refreshToken(String refreshToken) {
        return null;
    }

    @Override
    public void logout(String accessToken) {

    }

    @Override
    public boolean checkToken(String jwtToken) {
        return false;
    }
}

