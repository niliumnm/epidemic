package com.cdut.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Tag(name = "InRequestController", description = "进门请求")
public class InRequestSyscontrolController {

    @Operation(description = "发送进门请求")
    @RequestMapping(value = "/in/post", method = POST)
    AjaxResult postRequest(@RequestBody Map<String, Object> mp) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/in/post";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @Operation(description = "撤销进门请求")
    @RequestMapping(value = "/in/del", method = DELETE)
    AjaxResult delRequest(@RequestParam Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/in/del";
        restTemplate.delete(url, id);
        return AjaxResult.success("撤销成功",1);
    }

    @Operation(description = "领导查询所有进门请求")
    @RequestMapping(value = "/in/all", method = GET)
    AjaxResult getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/in/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @Operation(description = "根据ID查询所有进门请求")
    @RequestMapping(value = "/in/all/{userid}", method = GET)
    AjaxResult getAllById(@PathVariable("userid") Integer userId) {
        Map<String, Object> mp = new HashMap<>();
        mp.put("userid", userId);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/in/all/{userid}";
        return restTemplate.getForObject(url, AjaxResult.class, mp);
    }

    @Operation(description = "根据ID更新进门请求")
    @RequestMapping(value = "/in/update/", method = POST)
    AjaxResult updateById(@RequestBody Map<String, Object> mp) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/in/update";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @RequestMapping(value = "/in/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/in/page";
        Map mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        return restTemplate.getForObject(url, AjaxResult.class, mp);

    }
}
