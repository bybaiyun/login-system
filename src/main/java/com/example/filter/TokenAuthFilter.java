package com.example.filter;

import com.example.service.CustomTokenService;
import com.example.service.CustomUserDetailsService;
import com.example.utils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Token认证过滤器
 * @Author: suragi
 * @Date: 2024/12/26 16:40
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class TokenAuthFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    private final CustomUserDetailsService userDetailsService;
    private final CustomTokenService customTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String uri = request.getRequestURI();

        //不需要认证的接口直接放行
        if (uri.contains("/login") || uri.contains("/refresh")) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = "";

        //从请求头中的 Authorization 属性中获取 accessToken
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            accessToken = authorizationHeader;
        }

        //验证 accessToken 是否有效
        customTokenService.validateAccessToken(accessToken);

        String usernameFromToken = TokenUtils.extractUsernameFromToken(accessToken);
        UserDetails details = userDetailsService.loadUserByUsername(usernameFromToken);

        //为什么还要设置一次？
        //因为SecurityContextHolder是与线程相关的，每次请求都会创建一个新的线程
        assert details != null;
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities()));

        filterChain.doFilter(request, response);
    }
}

