package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import com.cdut.epidemicsyscontrolframework.services.SysLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLogoutController {
    @Autowired
    private SysLogoutService logoutService;

    @GetMapping("/user/logout")
    public AjaxResult logout(){
        String logout = logoutService.logout();
        return AjaxResult.success(logout);
    }
}
