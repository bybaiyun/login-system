package com.example.service;

import com.example.common.CustomUserDetails;
import com.example.common.TokenPair;
import com.example.common.UserToken;

import java.util.List;

public interface CustomTokenService {
    /**
     * 验证refreshToken是否有效<p>
     * 包括是否伪造、是否过期<p>
     * 如果无效则抛出异常
     * @param refreshToken
     */
    void validateRefreshToken(String refreshToken);

    /**
     * 创建accessToken & refreshToken
     * @param userDetails
     * @return
     */
    TokenPair createTokenPair(CustomUserDetails userDetails);

    /**
     * 由refreshToken创建accessToken
     * @param refreshToken
     * @return
     */
    TokenPair createAccessTokenByRefreshToken(String refreshToken);

    void logoutByDetail(CustomUserDetails details);

    void save(UserToken token);

    void validateAccessToken(String accessToken);

    void disableByUserIds(List<Long> userIds);
}
