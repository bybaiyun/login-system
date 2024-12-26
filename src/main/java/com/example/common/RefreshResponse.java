package com.example.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: suragi
 * @Date: 2024/12/26 14:17
 * @Description:
 */
@Data
@Builder
public class RefreshResponse implements Serializable {
    private String accessToken;
    private LocalDateTime accessTokenExpiresAt;
}

