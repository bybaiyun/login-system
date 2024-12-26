package com.example.mapper;

import com.example.common.UserToken;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserTokenMapper {

    void insert(UserToken token);

    UserToken findById(Long id);

    List<UserToken> findByUserId(Long userId);

    void update(UserToken token);

    void delete(Long id);

    List<UserToken> findByRefreshToken(String refreshToken);

    void updateAccessTokenByRefreshToken(String accessToken, LocalDateTime accessTokenExpiresAt, String refreshToken);

    void updateStatusByUserIdAndDeviceId(UserToken.TokenStatus tokenStatus, Long userId, String deviceId);
}
