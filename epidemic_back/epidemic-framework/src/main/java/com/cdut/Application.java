package com.cdut;

import com.cdut.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.cdut.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
//        System.out.println(userDao.findByName("asds"));
    }
}