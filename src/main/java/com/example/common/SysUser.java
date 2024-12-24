package com.example.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SysUser{
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String email;
    private String phoneNumber;
    private Integer status = 1; // 默认启用
    private String role = "user"; // 默认角色
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Integer deleted = 0; // 默认未删除
}
