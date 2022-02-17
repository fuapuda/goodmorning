package com.example.website.util;
import org.springframework.util.DigestUtils;

public class PasswordUtils {
    public static String encode(String password, String salt) {
        // salt+password+salt 进行3次加密
        String msg = salt + password + salt;
        for (int i = 0; i < 3; i++) {
            msg = DigestUtils.md5DigestAsHex(msg.getBytes());
        }
        return msg;
    }
}
