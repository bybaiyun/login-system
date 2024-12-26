package com.example.service.impl;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.example.common.CustomUserDetails;
import com.example.common.SysUser;
import com.example.common.TokenPair;
import com.example.common.UserToken;
import com.example.mapper.SysUserMapper;
import com.example.mapper.UserTokenMapper;
import com.example.service.CustomTokenService;
import com.example.utils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 自定义token服务实现类
 * @Author: suragi
 * @Date: 2024/12/24 21:49
 * @Description:
 */
@Service
public class CustomTokenServiceImpl implements CustomTokenService {

    /**
     * AccessToken有效时长
     * 默认：1小时，单位：毫秒
     */
    private final static long ACCESS_TOKEN_EXPIRE_TIME = 60 * 60 * 1000;

    /**
     * RefreshToken有效时长
     * 默认：30天，单位：天
     */
    private final static int REFRESH_TOKEN_EXPIRE_TIME = 30;

    @Resource
    private UserTokenMapper userTokenMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void validateRefreshToken(String refreshToken) {
        List<UserToken> refreshTokens = userTokenMapper.findByRefreshToken(refreshToken);
        if (refreshTokens.isEmpty()) {
            throw new RuntimeException("无效的RefreshToken");
        }
        LocalDateTime refreshTokenExpiresAt = refreshTokens.get(0).getRefreshTokenExpiresAt();
        //refreshToken存在但已过期
        if (LocalDateTime.now().isAfter(refreshTokenExpiresAt)) {
            throw new RuntimeException("RefreshToken已过期，请重新登录");
        }
    }

    @Override
    public TokenPair createTokenPair(CustomUserDetails userDetails) {
        String accessToken = TokenUtils.generateAccessToken(userDetails.getUsername());
        String refreshToken = TokenUtils.generateRefreshToken();
        return TokenPair.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiresAt(LocalDateTime.now().plus(Duration.ofMillis(ACCESS_TOKEN_EXPIRE_TIME)))
                .refreshTokenExpiresAt(LocalDateTime.now().plus(Duration.ofDays(REFRESH_TOKEN_EXPIRE_TIME)))
                .build();
    }

    @Override
    public TokenPair createAccessTokenByRefreshToken(String refreshToken) {
        List<UserToken> userTokens = userTokenMapper.findByRefreshToken(refreshToken);
        if (userTokens.isEmpty()) {
            throw new RuntimeException("无效的RefreshToken");
        }
        SysUser user = sysUserMapper.findByUserId(userTokens.get(0).getUserId());
        String accessToken = TokenUtils.generateAccessToken(user.getUsername());
        LocalDateTime accessTokenExpiresAt = LocalDateTime.now().plus(Duration.ofMillis(ACCESS_TOKEN_EXPIRE_TIME));
        userTokenMapper.updateAccessTokenByRefreshToken(accessToken, accessTokenExpiresAt, refreshToken);
        return TokenPair.builder()
                .accessToken(accessToken)
                .accessTokenExpiresAt(accessTokenExpiresAt)
                .build();
    }

    @Override
    public void logoutByDetail(CustomUserDetails details) {
        //将当前用户从当前设备登出，即将这条token记录状态置为过期
        //若deviceId为null，则将当前用户从所有设备登出
        userTokenMapper.updateStatusByUserIdAndDeviceId(UserToken.TokenStatus.EXPIRED, details.getUserId(), details.getDeviceId());
    }

    @Override
    public void save(UserToken token) {
        userTokenMapper.insert(token);
    }

    @Override
    public void validateAccessToken(String accessToken) {
        UserToken userToken = userTokenMapper.findByAccessToken(accessToken);
        if (userToken == null) {
            throw new RuntimeException("无效的AccessToken");
        }
    }

    @Override
    public void disableByUserIds(List<Long> userIds) {
        userTokenMapper.disableByUserIds(userIds);
    }
}

