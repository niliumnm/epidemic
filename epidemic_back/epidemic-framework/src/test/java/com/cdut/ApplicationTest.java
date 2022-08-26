package com.cdut;


import com.cdut.service.UserService;
import com.cdut.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test(){
//        System.out.println(userDao.findByName("asds"));
        System.out.println(userService.getAll());
    }
}
