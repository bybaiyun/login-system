package com.example.loginsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: suragi
 * @Date: 2024/12/24 18:04
 * @Description:
 */
@SpringBootTest
public class BizTests {
    @Test
    public void test(){
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        String encoded = pw.encode("suragi");
        System.out.println(encoded);
        boolean matches = pw.matches("suragi", encoded);
        System.out.println(matches);
    }
}

