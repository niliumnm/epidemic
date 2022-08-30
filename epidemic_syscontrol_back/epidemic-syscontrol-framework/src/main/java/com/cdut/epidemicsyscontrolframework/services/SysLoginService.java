package com.cdut.epidemicsyscontrolframework.services;

import com.cdut.epidemicsyscontrolcommon.utils.JWTUtil;
import com.cdut.epidemicsyscontrolcommon.utils.RedisCache;
import com.cdut.epidemicsyscontrolframework.security.AuthenticationContextHolder;
import com.cdut.epidemicsyscontrolsystem.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class SysLoginService {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String username, String password, String code, String validateKey){
        String realCode = redisCache.getCacheObject(validateKey);
        if(realCode==null)
            throw new RuntimeException("验证码已过期");
        if(!realCode.equals(code))
            throw new RuntimeException("验证码错误");
        Authentication authentication = null;
        try{
            // 验证用户
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            authentication = authenticationManager.authenticate(authenticationToken);
        }catch (Exception e){
            // 验证失败
            throw new RuntimeException("用户名或密码错误");
        }
        if(Objects.isNull(authentication))
            throw new RuntimeException("认证未通过");
        //
        LoginUser sysUser = (LoginUser)authentication.getPrincipal();
        String token = JWTUtil.sign(sysUser.getUsername());

        redisCache.setCacheObject(sysUser.getUsername(), sysUser);

        return token;
    }
}
