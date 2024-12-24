package com.example.common;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserToken{
    private Long id;
    private Long userId;
    private String accessToken;
    private String refreshToken;
    private String deviceType;
    private String deviceId;
    private String ipAddress;
    private LocalDateTime createTime;
    private LocalDateTime accessTokenExpiresAt;
    private LocalDateTime refreshTokenExpiresAt;
    private TokenStatus status = TokenStatus.ACTIVE; // 默认状态

    public enum TokenStatus {
        ACTIVE, REVOKED, EXPIRED
    }

    // Getters and Setters
}
