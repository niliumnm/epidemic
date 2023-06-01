package com.cdut.epidemicsyscontrolframework.security;

import com.cdut.pojo.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    public static String getUsername(){
        return getLoginUser().getUsername();
    }

    public static LoginUser getLoginUser(){
        logger.info("获取当前用户");
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        }catch (Exception e){
            throw new RuntimeException("用户信息获取异常");
        }
    }

    public static Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String encryptPassword(String metaPassword){
        return new BCryptPasswordEncoder().encode(metaPassword);
    }

    public static boolean matches(String metaPassword, String encryptPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(metaPassword, encryptPassword);
    }

    public static boolean isAdmin(LoginUser user){
        return user.getId() == 1;
    }
}