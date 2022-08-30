package com.cdut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EpidemicSyscontrolAdminApplication {

    private static final Logger sysLogger = LoggerFactory.getLogger(EpidemicSyscontrolAdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EpidemicSyscontrolAdminApplication.class, args);
        sysLogger.info("后台管理系统启动");
    }

}
