package com.example.controller;

import com.example.common.Result;
import com.example.common.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: suragi
 * @Date: 2024/12/25 15:34
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class BizController {
    @GetMapping("/getUsers")
    public Result<List<SysUser>> getUsers(){
        return Result.success(List.of(new SysUser()));
    }
}

