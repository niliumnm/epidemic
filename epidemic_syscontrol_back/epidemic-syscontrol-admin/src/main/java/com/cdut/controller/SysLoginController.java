package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import com.cdut.epidemicsyscontrolframework.services.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @PostMapping(value = "/login")
    public AjaxResult login(@RequestBody Map<String, Object>req){
        String username = (String)req.get("username");
        String password = (String) req.get("password");
        String code = (String) req.get("code");
        String validateKey = (String) req.get("validateKey");
        String token = loginService.login(username, password, code, validateKey);
        return AjaxResult.success("登录成功",token);
    }
}
