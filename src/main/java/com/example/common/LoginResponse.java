package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: suragi
 * @Date: 2024/12/23 20:22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse implements Serializable {
    private Long userId;
    private String username;
    private String accessToken;
    private String refreshToken;
    /**
     * accessToken过期时间
     */
    private LocalDateTime accessTokenExpiresAt;
}

