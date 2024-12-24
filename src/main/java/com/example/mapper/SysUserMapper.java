package com.example.mapper;

import com.example.common.SysUser;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SysUserMapper {

    void insert(SysUser user);

    SysUser findById(Long id);

    List<SysUser> findAll();

    void update(SysUser user);

    void delete(Long id);

    SysUser findByUserName(String userName);
}
