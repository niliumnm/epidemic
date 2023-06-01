package com.cdut.epidemicsyscontrolframework.services;

import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.pojo.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ps")
public class PermissionService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public boolean hasPermission(String permission){
        LoginUser loginUser = SecurityUtil.getLoginUser();
        if(SecurityUtil.isAdmin(loginUser))
            return true;
        return loginUser.getPermissions().contains(permission);
    }

}
