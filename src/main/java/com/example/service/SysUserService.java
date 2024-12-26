package com.example.service;

import com.example.common.SysUser;

import java.util.List;

/**
 * @Author: suragi
 * @Date: 2024/12/26 18:22
 * @Description:
 */
public interface SysUserService {
    SysUser findByUsername(String username);

    SysUser findByUserId(Long userId);

    Boolean saveUsers(List<SysUser> sysUsers);
}

