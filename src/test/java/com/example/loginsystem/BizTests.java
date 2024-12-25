package com.example.loginsystem;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: suragi
 * @Date: 2024/12/24 18:04
 * @Description:
 */
public class BizTests {
    @Test
    public void test(){
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        String encoded = pw.encode("123456");
        System.out.println(encoded);
        boolean matches = pw.matches("123456", encoded);
        System.out.println(matches);
    }
}

