package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @PreAuthorize("@ps.hasPermission('admin')")
    @GetMapping("/test")
    public AjaxResult test(){
        return AjaxResult.success("测试成功", SecurityUtil.getUsername());
    }
}
