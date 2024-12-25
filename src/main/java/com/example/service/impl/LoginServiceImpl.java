package com.example.service.impl;

import com.example.common.CustomUserDetails;
import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.service.CustomTokenService;
import com.example.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
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
    public LoginResponse login(CustomUserDetails userDetails) {
        String accessToken = tokenService.createAccessToken(userDetails);
        return new LoginResponse(accessToken, "");
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

