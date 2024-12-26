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

    void checkAccountStatus(Integer status);

    SysUser findByUserId(Long userId);

    Boolean saveUsers(List<SysUser> sysUsers);

    /**
     * 禁用用户账户<p>
     * 需要管理员权限<p>
     * @param userIds
     */
    void disableUserAccount(List<Long> userIds);
}

