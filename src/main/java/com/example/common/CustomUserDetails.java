package com.example.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author: suragi
 * @Date: 2024/12/23 21:58
 * @Description:
 */
public class CustomUserDetails extends User {

    private Long userId;
    private String accessToken;
    //private String refreshToken;
    private String deviceId;

    public CustomUserDetails(Long userId, String username, String password,
                             String deviceId, String accessToken, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.accessToken = accessToken;
        //this.refreshToken = refreshToken;
        this.deviceId = deviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}

