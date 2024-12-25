package com.example.service.impl;

import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.service.CustomTokenService;
import com.example.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

/**
 * @Author: suragi
 * @Date: 2024/12/23 20:41
 * @Description:
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private CustomTokenService tokenService;

    @Override
    public LoginResponse login(LoginRequest request) {

        return new LoginResponse();
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

