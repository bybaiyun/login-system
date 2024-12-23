package com.example.common;

import lombok.Data;

/**
 * @Author: suragi
 * @Date: 2024/12/23 20:31
 * @Description:
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
    private String accessToken;
}

