package com.cdut;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootTest
public class UserTest {
//    private RestTemplate restTemplate = new RestTemplate();
    private String host = "localhost:";
    private int port = 8088;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void userGetIdTest(){
        String url = host + port + "/user/getid";
        HashMap<String, Object> param = new HashMap<>();
        param.put("id", 58);
        String s = HttpUtil.get(url, param);
        log.info("user by id 58: " + s);
    }
    @Test
    public void getAllUsers(){
        String url = host + port + "/getAllUsers";
        log.info(HttpUtil.get(url));
    }



}
