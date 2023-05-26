package com.cdut.epidemicsyscontrolframework.services;

import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.epidemicsyscontrolsystem.pojo.LoginUser;
import com.cdut.epidemicsystem.pojo.InRequest;
import com.cdut.epidemicsystem.pojo.OutRequest;
import com.cdut.epidemicsystem.pojo.Vistor;
import com.cdut.epidemicsystem.service.impl.UserServiceImpl;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cdut.epidemicsystem.service.impl.ReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ps")
public class PermissionService {
    @Autowired
    ReplyServiceImpl replyService;
    @Autowired
    UserServiceImpl userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public boolean hasPermission(String permission){
        LoginUser loginUser = SecurityUtil.getLoginUser();
        if(SecurityUtil.isAdmin(loginUser))
            return true;
        return loginUser.getPermissions().contains(permission);
    }

}
