package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: suragi
 * @Date: 2024/12/26 14:14
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
public class TokenPair {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime accessTokenExpiresAt;
}

