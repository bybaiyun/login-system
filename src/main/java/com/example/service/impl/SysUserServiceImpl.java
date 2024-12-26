package com.example.service.impl;

import com.example.common.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.SysUserService;
import lombok.RequiredArgsConstructor;
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


    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUserName(username);
    }

    @Override
    public SysUser findByUserId(Long userId) {
        return sysUserMapper.findByUserId(userId);
    }

    @Override
    public Boolean saveUsers(List<SysUser> sysUsers) {
        return null;
    }
}

