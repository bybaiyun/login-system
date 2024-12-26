package com.example.utils;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Base64;
import java.util.UUID;

/**
 * @Author: suragi
 * @Date: 2024/12/26 14:28
 * @Description:
 */
public class TokenUtils {
    public static String generateAccessToken() {
        return UUID.randomUUID().toString();
    }

    public static String generateRefreshToken() {
        return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
    }
}

