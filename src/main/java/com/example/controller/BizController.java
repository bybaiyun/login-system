package com.example.controller;

import com.example.common.Result;
import com.example.common.SysUser;
import com.example.common.SysUserRequest;
import com.example.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: suragi
 * @Date: 2024/12/25 15:34
 * @Description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class BizController {

    private final SysUserService sysUserService;

    @GetMapping("/getUsers")
    public Result<List<SysUser>> getUsers(){
        return Result.success(List.of(new SysUser()));
    }

    @PostMapping("/disableUsers")
    public Result disableUserAccount(@RequestBody List<Long> userIds){
        sysUserService.disableUserAccount(userIds);
        return Result.success("操作成功");
    }
}

