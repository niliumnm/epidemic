package com.cdut;

import com.cdut.epidemicsyscontrolsystem.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EpidemicSyscontrolAdminApplicationTests {

    @Autowired
    private SysUserService sysUserService;

    @Test
    void contextLoads() {
        System.out.println(sysUserService.getSysUserByUsername("hoshino"));
    }

}
