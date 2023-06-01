package com.cdut.epidemicsyscontrolframework.services;

import com.cdut.pojo.LoginUser;
import com.cdut.pojo.SysUser;
import com.cdut.service.SysUserRoleService;
import com.cdut.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysUserDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(SysUserDetailsService.class);

    @Autowired
    private SysUserService userService;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getSysUserByUsername(username);
        log.info(username);
        if(user == null){
            log.info("用户"+username+"不存在");
            throw new UsernameNotFoundException("用户"+username+"不存在");
        }
//        validationService.validate(user);
        return createLoginUser(user);
    }
    public UserDetails createLoginUser(SysUser user){
        List<String> userRoles = userRoleService.getUserRoles(user.getId());
        Set<String> roles = new HashSet<>(userRoles);
        return new LoginUser(user.getId(), roles, user);
    }
}

