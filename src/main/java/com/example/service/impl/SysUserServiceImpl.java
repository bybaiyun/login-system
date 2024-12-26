package com.example.service.impl;

import com.example.AccountStatusEnum;
import com.example.common.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.CustomTokenService;
import com.example.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: suragi
 * @Date: 2024/12/26 18:22
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper sysUserMapper;

    private final CustomTokenService customTokenService;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUserName(username);
    }

    @Override
    public void checkAccountStatus(Integer status) {
        switch (AccountStatusEnum.values()[status]) {
            case INACTIVE:
                throw new DisabledException("账户已被禁用，请联系管理员");
            case LOCKED:
                throw new LockedException("账户已被锁定，请联系管理员");
            case DELETED:
                throw new DisabledException("账户已被删除，请联系管理员");
            case ACTIVE:
                // No action needed for active accounts
                break;
            default:
                throw new IllegalStateException("账户状态异常：" + status);
        }
    }

    @Override
    public SysUser findByUserId(Long userId) {
        return sysUserMapper.findByUserId(userId);
    }

    @Override
    public Boolean saveUsers(List<SysUser> sysUsers) {
        return null;
    }

    @Override
    public void disableUserAccount(List<Long> userIds) {
        //todo 权限校验
        //修改用户状态为禁用：status == 0
        sysUserMapper.disableUserAccount(userIds);
        //将该用户的所有token失效
        customTokenService.disableByUserIds(userIds);
    }
}

