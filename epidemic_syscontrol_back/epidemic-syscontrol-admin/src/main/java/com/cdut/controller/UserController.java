package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


// TODO: 2022/9/1 获取前台相关数据

@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;
    @Value("${front.port}")
    private int port;
    @Value("${front.host}")
    private String host;

    @GetMapping("/restTest")
    public AjaxResult test(){
        String url = "http://"+host+":"+port;
        log.info(url);
        AjaxResult result = restTemplate.getForObject(url + "/getAllUsers", AjaxResult.class);
        return result;
    }
}
