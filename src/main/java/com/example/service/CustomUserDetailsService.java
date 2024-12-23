package com.example.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * 自定义spring security相关的用户信息查询逻辑
 * @Author: suragi
 * @Date: 2024/12/23 20:50
 * @Description:
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // 关联sys_user表的JPA仓库或Mapper
    private final TokenRepository tokenRepository; // 关联user_token表的JPA仓库或Mapper

    public CustomUserDetailsService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        SysUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // 查询用户Token信息
        UserToken userToken = tokenRepository.findByUserId(user.getId())
                .orElseThrow(() -> new UsernameNotFoundException("Token not found"));

        // 创建UserDetails
        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                userToken.getDeviceId(),
                userToken.getAccessToken(),
                Collections.emptyList() // 权限列表，后续可扩展
        );
    }
}

