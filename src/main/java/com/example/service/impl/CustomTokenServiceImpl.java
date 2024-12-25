package com.example.service.impl;

import com.example.common.CustomUserDetails;
import com.example.service.CustomTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * 自定义token服务实现类
 * @Author: suragi
 * @Date: 2024/12/24 21:49
 * @Description:
 */
@Service
public class CustomTokenServiceImpl implements CustomTokenService {

    @Resource
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public String createAccessToken(CustomUserDetails userDetails) {
        return objectMapper.writeValueAsString(userDetails);
    }
}

