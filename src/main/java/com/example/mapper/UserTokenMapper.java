package com.example.mapper;

import com.example.common.SysUser;
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

    void updateAccessTokenByRefreshToken(String accessToken,
                                         LocalDateTime accessTokenExpiresAt, String refreshToken);

    void updateStatusByUserIdAndDeviceId(@Param("status") UserToken.TokenStatus tokenStatus,
                                         @Param("userId") Long userId, @Param("deviceId") String deviceId);

    UserToken findByAccessToken(String accessToken);

    void disableByUserIds(List<Long> userIds);
}
