package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
