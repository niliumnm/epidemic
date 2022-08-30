package com.cdut;

import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.epidemicsyscontrolframework.services.SysLoginService;
import com.cdut.epidemicsyscontrolframework.services.SysUserDetailsService;
import com.cdut.epidemicsyscontrolsystem.pojo.LoginUser;
import com.cdut.epidemicsyscontrolsystem.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class EpidemicSyscontrolAdminApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserDetailsService detailsService;

    @Autowired
    SysLoginService sysLoginService;
    @Test
    void contextLoads() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.matches("123456", "$2a$10$geC7vaAjgUt9sWsbtkQKpO1DAv7975GAx5tSQwgraSkJuB.gu8sxK"));
//        System.out.println(encode);
        sysLoginService.login("hoshino", "123456", "5a8a", "73bc0f4a-7ac0-4947-b08d-fce7b47737d9");
        LoginUser loginUser = SecurityUtil.getLoginUser();
        System.out.println(loginUser);
    }

}
