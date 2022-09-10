package com.cdut;

import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.epidemicsyscontrolframework.services.SysLoginService;
import com.cdut.epidemicsyscontrolframework.services.SysUserDetailsService;
import com.cdut.epidemicsyscontrolsystem.pojo.LoginUser;

import com.cdut.epidemicsyscontrolsystem.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class EpidemicSyscontrolAdminApplicationTests {

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    SysLoginService sysLoginService;
    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
        System.out.println(encoder.matches("123456", "$2a$10$jhlNq4kvUFftAFNgL9oDCurdXC6c2CLzJAFjS1IbChAuc7FGQK3CS"));
    }

}
