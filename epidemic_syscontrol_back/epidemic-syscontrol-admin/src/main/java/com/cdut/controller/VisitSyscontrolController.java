package com.cdut.controller;


import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Tag(name = "VisitSyscontrolController", description = "访问请求")
public class VisitSyscontrolController {

    @Value("${front.port}")
    private int port;
    @Value("${front.host}")
    private String host;

    @Operation(description = "发送外来请求")
    @RequestMapping(value = "/vis/post", method = POST)
    AjaxResult postRequest(@RequestBody Map<String,Object> mp) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/vis/post";
//        String url = "http://localhost:8088/vis/post";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @Operation(description = "根据UserId查所有外来请求")
    @RequestMapping(value = "/vis/all/{userid}", method = GET)
    AjaxResult getAllVisById(@PathVariable("userid") Integer userid) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/vis/all/{userid}";
//        String url = "http://localhost:8088/vis/all/{userid}";
        return restTemplate.getForObject(url, AjaxResult.class, userid);
    }

    @Operation(description = "撤销外来请求")
    @RequestMapping(value = "/vis/del", method = DELETE)
    AjaxResult delRequest(@RequestParam Integer id) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/vis/del?id={id}";
//        String url = "http://localhost:8088/vis/del?id={id}";
        restTemplate.delete(url, id);
        return AjaxResult.success("撤销成功",1);
    }

    @Operation(description = "领导查询所有访客来访请求")
    @RequestMapping(value = "/vis/all", method = GET)
    AjaxResult getAll() throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/vis/all";
//        String url = "http://localhost:8088/vis/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @Operation(description = "根据ID更新访客请求")
    @RequestMapping(value = "/vis/update/", method = POST)
    AjaxResult updateById(@RequestBody Map<String,Object> mp) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/vis/update/";
//        String url = "http://localhost:8088/vis/update/";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @RequestMapping(value = "/vis/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/vis/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
//        String url = "http://localhost:8088/vis/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
        Map<String,Object> mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        return restTemplate.getForObject(url, AjaxResult.class, mp);
    }


}
