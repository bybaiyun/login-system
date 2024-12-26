package com.example.service.impl;

import com.example.common.*;
import com.example.service.CustomTokenService;
import com.example.service.LoginService;
import com.example.utils.IPUtils;
import com.example.utils.SecurityUtils;
import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public LoginResponse login(CustomUserDetails userDetails, LoginRequest loginRequest) {
        TokenPair pair = tokenService.createTokenPair(userDetails);
        tokenService.save(buildUserToken(userDetails, pair, loginRequest));
        return buildLoginResponse(userDetails, pair);
    }

    @Override
    public RefreshResponse refreshToken(String refreshToken) {
        tokenService.validateRefreshToken(refreshToken);
        TokenPair tokenPair = tokenService.createAccessTokenByRefreshToken(refreshToken);
        return RefreshResponse.builder()
                .accessToken(tokenPair.getAccessToken())
                .accessTokenExpiresAt(tokenPair.getAccessTokenExpiresAt())
                .build();
    }

    @Override
    public void logout() {
        CustomUserDetails details = SecurityUtils.getCurrentUserDetails();
        tokenService.logoutByDetail(details);
    }

    @Override
    public boolean checkToken(String jwtToken) {
        return false;
    }

    private UserToken buildUserToken(CustomUserDetails details, TokenPair pair, LoginRequest request){
        return UserToken.builder()
                .userId(details.getUserId())
                .accessToken(pair.getAccessToken())
                .accessTokenExpiresAt(pair.getAccessTokenExpiresAt())
                .refreshToken(pair.getRefreshToken())
                .refreshTokenExpiresAt(pair.getRefreshTokenExpiresAt())
                .deviceId(request.getDeviceId())
                .deviceType(request.getDeviceType())
                .ipAddress(details.getIpAddress())
                .status(UserToken.TokenStatus.ACTIVE)
                .build();
    }

    private LoginResponse buildLoginResponse(CustomUserDetails userDetails, TokenPair pair) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setRefreshToken(pair.getRefreshToken());
        loginResponse.setAccessToken(pair.getAccessToken());
        loginResponse.setAccessTokenExpiresAt(pair.getAccessTokenExpiresAt());
        loginResponse.setUserId(userDetails.getUserId());
        loginResponse.setUsername(userDetails.getUsername());
        return loginResponse;
    }
}

