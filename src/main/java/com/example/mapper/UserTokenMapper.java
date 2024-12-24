package com.example.mapper;

import com.example.common.UserToken;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserTokenMapper {

    @Insert("INSERT INTO user_token (user_id, access_token, refresh_token, device_type, device_id, ip_address, create_time, access_token_expires_at, refresh_token_expires_at, status) "+
            "VALUES (#{userId}, #{accessToken}, #{refreshToken}, #{deviceType}, #{deviceId}, #{ipAddress}, #{createTime}, #{accessTokenExpiresAt}, #{refreshTokenExpiresAt}, #{status})")
    void insert(UserToken token);

    @Select("SELECT * FROM user_token WHERE id = #{id}")
    UserToken findById(Long id);

    @Select("SELECT * FROM user_token WHERE user_id = #{userId}")
    List<UserToken> findByUserId(Long userId);

    @Update("UPDATE user_token SET user_id = #{userId}, access_token = #{accessToken}, refresh_token = #{refreshToken}, "+
            "device_type = #{deviceType}, device_id = #{deviceId}, ip_address = #{ipAddress}, create_time = #{createTime}, "+
            "access_token_expires_at = #{accessTokenExpiresAt}, refresh_token_expires_at = #{refreshTokenExpiresAt}, status = #{status} "+
            "WHERE id = #{id}")
    void update(UserToken token);

    @Delete("DELETE FROM user_token WHERE id = #{id}")
    void delete(Long id);
}
