package com.example.common;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author: suragi
 * @Date: 2024/12/23 21:58
 * @Description:
 */
@Builder
public class CustomUserDetails extends User {

    private Long userId;
    private String accessToken;
    //private String refreshToken;
    private String deviceId;


    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUserDetails(Long userId, String username, String password,
                             String accessToken, String deviceId, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.accessToken = accessToken;
        //this.refreshToken = refreshToken;
        this.deviceId = deviceId;
    }
}

