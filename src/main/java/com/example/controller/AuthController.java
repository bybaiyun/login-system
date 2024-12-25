package com.example.controller;

import com.example.common.CustomUserDetails;
import com.example.common.LoginRequest;
import com.example.common.LoginResponse;
import com.example.common.Result;
import com.example.service.LoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * @Author: suragi
 * @Date: 2024/12/23 20:21
 * @Description: 处理登录相关逻辑
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private LoginService loginService;

    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        log.info("用户登录请求: {}", loginRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(authentication == null){
            log.error("authentication对象为空");
            return Result.error("登陆失败");
        }
        /**
         * authention 对象的各个属性说明
         * 1. principal: 认证主体，通常是用户的详细信息
         *    如果使用 Spring Security 默认的 UserDetailsService，则返回一个 UserDetails 实例。
         *    如果认证失败，可能为 null。
         * 2. credentials: 认证凭证，这里为密码
         * 3. authorities: 认证权限，这里为用户角色
         * 4. details: 认证详情，这里为用户信息
         * 5. authenticated: 认证状态，这里为true
         * 6. name: 返回认证主体的名称，通常是用户名，与getPrincipal()返回的用户名一致
         *
         *
         * 通常不直接使用 authentication 对象，因为我们在 userDetailService 中会自定义 loadUserByUsername 方法
         * 该方法会返回一个自定义的 CustomUserDetails对象，该对象中包含用户信息，包括 userId，用户名、密码、角色权限等。
         * 该自定义返回对象会被封装进 UserDetails 的 principal 属性中
         * 所以将 authentication 的 principal 推荐降级成 CustomUserDetails
         */
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        LoginResponse response = loginService.login(userDetails);
        log.info("用户登录成功: {}", response);
        return Result.success(response);
    }

    @PostMapping("/logout")
    public Result<String> logout(){
        log.info("用户登出请求");
        return Result.success("ok");
    }

    @PostMapping("/refresh")
    public Result<LoginResponse> refresh(){
        log.info("刷新token请求");
        return Result.success(null);
    }
}

