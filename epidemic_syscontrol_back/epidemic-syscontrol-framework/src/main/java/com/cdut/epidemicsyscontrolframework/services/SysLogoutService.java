package com.cdut.epidemicsyscontrolframework.services;

import com.cdut.epidemicsyscontrolcommon.utils.RedisCache;
import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogoutService {

    @Autowired
    private RedisCache redisCache;

    public String logout(){
        LoginUser loginUser = SecurityUtil.getLoginUser();

        boolean b = redisCache.deleteObject(loginUser.getUsername());

        return b ?"退出成功":"退出失败";

    }
}
