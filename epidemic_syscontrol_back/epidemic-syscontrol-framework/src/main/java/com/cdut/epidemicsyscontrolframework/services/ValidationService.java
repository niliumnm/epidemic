package com.cdut.epidemicsyscontrolframework.services;

import com.cdut.epidemicsyscontrolframework.security.AuthenticationContextHolder;
import com.cdut.pojo.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validate(SysUser user){
        Authentication usernamePasswordAuthenticationToken = AuthenticationContextHolder.getContext();
        String username = usernamePasswordAuthenticationToken.getName();
        String password = usernamePasswordAuthenticationToken.getCredentials().toString();

    }
}
