package com.example.common;

import java.io.Serializable;

/**
 * @Author: suragi
 * @Date: 2024/12/26 19:01
 * @Description:
 */
public class CryptAuthInfo implements Serializable {
    private String username;
    private String tokenValue;

    public CryptAuthInfo(String username, String tokenValue) {
        this.username = username;
        this.tokenValue = tokenValue;
    }

    public CryptAuthInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}

