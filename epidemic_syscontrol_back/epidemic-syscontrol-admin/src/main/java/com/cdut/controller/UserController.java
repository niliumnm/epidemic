package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


// TODO: 2022/9/1 获取前台相关数据

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/restTest")
    public AjaxResult test(){
        AjaxResult result = restTemplate.getForObject("http://localhost:8088/getAllUsers", AjaxResult.class);
        return result;
    }
}
