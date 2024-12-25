package com.example.service;

import com.example.common.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomTokenService {
    /**
     * 创建accessToken
     * @param userDetails
     * @return
     */
    String createAccessToken(CustomUserDetails userDetails);
}
