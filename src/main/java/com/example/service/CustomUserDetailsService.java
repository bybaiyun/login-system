package com.example.service;

import com.example.common.CustomUserDetails;
import com.example.common.SysUser;
import com.example.common.UserToken;
import com.example.mapper.SysUserMapper;
import com.example.mapper.UserTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

/**
 * 自定义spring security相关的用户信息查询逻辑
 * @Author: suragi
 * @Date: 2024/12/23 20:50
 * @Description:
 */
@Service("customUserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final SysUserMapper sysUserMapper;

    private final UserTokenMapper userTokenMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 查询用户信息
        SysUser user = sysUserMapper.findByUserName(userName);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found");
        }

        // 查询用户Token信息
        UserToken userToken = userTokenMapper.findByUserId(user.getId()).stream().findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Token not found"));

        // 创建UserDetails
        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                userToken.getAccessTokenExpiresAt(),
                userToken.getAccessToken(),
                userToken.getDeviceId(),
                Collections.emptyList() // 权限列表，后续可扩展
        );
    }
}

