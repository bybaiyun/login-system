package com.example.mapper;

import com.example.common.UserToken;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserTokenMapper {

    void insert(UserToken token);

    UserToken findById(Long id);

    List<UserToken> findByUserId(Long userId);

    void update(UserToken token);

    void delete(Long id);
}
