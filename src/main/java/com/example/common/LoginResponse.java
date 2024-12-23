package com.example.common;

import lombok.Data;

/**
 * @Author: suragi
 * @Date: 2024/12/23 20:22
 * @Description:
 */
@Data
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
}

