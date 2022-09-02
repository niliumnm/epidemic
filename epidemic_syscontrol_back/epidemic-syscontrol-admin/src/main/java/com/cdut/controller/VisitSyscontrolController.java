package com.cdut.controller;


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
@Tag(name = "VisitSyscontrolController", description = "访问请求")
public class VisitSyscontrolController {

    @Operation(description = "发送外来请求")
    @RequestMapping(value = "/vis/post", method = POST)
    AjaxResult postRequest(@RequestBody Map<String,Object> mp) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/vis/post";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @Operation(description = "根据UserId查所有外来请求")
    @RequestMapping(value = "/vis/all/{userid}", method = GET)
    AjaxResult getAllVisById(@PathVariable("userid") Integer userid) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/vis/all/{userid}";
        return restTemplate.getForObject(url, AjaxResult.class, userid);
    }

    @Operation(description = "撤销外来请求")
    @RequestMapping(value = "/vis/del", method = DELETE)
    AjaxResult delRequest(@RequestParam Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/vis/del";
        restTemplate.delete(url, id);
        return AjaxResult.success("撤销成功",1);
    }

    @Operation(description = "领导查询所有访客来访请求")
    @RequestMapping(value = "/vis/all", method = GET)
    AjaxResult getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/vis/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @Operation(description = "根据ID更新访客请求")
    @RequestMapping(value = "/vis/update/", method = POST)
    AjaxResult updateById(@RequestBody Map<String,Object> mp) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/vis/update";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @RequestMapping(value = "/vis/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http/localhost:8080/vis/page";
        Map mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        return restTemplate.getForObject(url, AjaxResult.class, mp);
    }


}
