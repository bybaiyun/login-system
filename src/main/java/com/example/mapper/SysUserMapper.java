package com.example.mapper;

import com.example.common.SysUser;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SysUserMapper {

    @Insert("INSERT INTO sys_user (username, password, real_name, email, phone_number, status, role, created_time, updated_time, deleted) "+
            "VALUES (#{username}, #{password}, #{realName}, #{email}, #{phoneNumber}, #{status}, #{role}, #{createdTime}, #{updatedTime}, #{deleted})")
    void insert(SysUser user);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser findById(Long id);

    @Select("SELECT * FROM sys_user")
    List<SysUser> findAll();

    @Update("UPDATE sys_user SET username = #{username}, password = #{password}, real_name = #{realName}, email = #{email}, "+
            "phone_number = #{phoneNumber}, status = #{status}, role = #{role}, updated_time = #{updatedTime}, deleted = #{deleted} "+
            "WHERE id = #{id}")
    void update(SysUser user);

    @Delete("DELETE FROM sys_user WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM sys_user WHERE username = #{userName}")
    SysUser findByUserName(String userName);
}
