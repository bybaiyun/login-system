package com.example.utils;

import com.example.common.CryptAuthInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author: suragi
 * @Date: 2024/12/26 14:28
 * @Description:
 */
public class TokenUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 生成AccessToken
     * accessToken = Base64(JSON序列化之后的CryptAuthInfo)
     * cryptAuthInfo = {username: username, tokenValue: UUID}
     * @param username
     * @return accessToken
     */
    @SneakyThrows
    public static String generateAccessToken(String username) {
        CryptAuthInfo info = new CryptAuthInfo();
        info.setUsername(username);
        info.setTokenValue(UUID.randomUUID().toString());
        return Base64.getEncoder().encodeToString(objectMapper.writeValueAsString(info).getBytes());
    }

    public static String generateRefreshToken() {
        return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
    }

    public static String extractUsernameFromToken(String token) {
        String jsonValue = new String(Base64.getDecoder().decode(token));
        try {
            CryptAuthInfo info = objectMapper.readValue(jsonValue, CryptAuthInfo.class);
            return info.getUsername();
        } catch (Exception e) {
            throw new RuntimeException("无效的AccessToken");
        }
    }
}

