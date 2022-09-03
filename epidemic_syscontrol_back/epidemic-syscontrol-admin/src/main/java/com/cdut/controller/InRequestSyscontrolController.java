package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.DataAmount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Configuration
@Tag(name = "InRequestController", description = "进门请求")
public class InRequestSyscontrolController {

    @Value("${server.port}")
    private int port;
    @Operation(description = "发送进门请求")
    @RequestMapping(value = "/in/post", method = POST)
    AjaxResult postRequest(@RequestBody Map<String, Object> mp) throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostAddress();
        RestTemplate restTemplate = new RestTemplate();
        String url = host + port + "/in/post";
//        String url = "http://localhost:8088/in/post";

        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @Operation(description = "撤销进门请求")
    @RequestMapping(value = "/in/del", method = DELETE)
    AjaxResult delRequest(@RequestParam Integer id) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = InetAddress.getLocalHost().getHostAddress();
        String url = host + port + "/in/del?id={id}";
//        String url = "http://localhost:8088/in/del?id={id}";
        restTemplate.delete(url, id);
        return AjaxResult.success("撤销成功",1);
    }

    @Operation(description = "领导查询所有进门请求")
    @RequestMapping(value = "/in/all", method = GET)
    AjaxResult getAll() throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = InetAddress.getLocalHost().getHostAddress();
        String url = host + port + "/in/all";
//        String url = "http://localhost:8088/in/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @Operation(description = "根据ID查询所有进门请求")
    @RequestMapping(value = "/in/all/{userid}", method = GET)
    AjaxResult getAllById(@PathVariable("userid") Integer userid) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = InetAddress.getLocalHost().getHostAddress();
        String url = host + port + "/in/all/{userid}";
//        String url = "http://localhost:8088/in/all/{userid}";
        return restTemplate.getForObject(url, AjaxResult.class, userid);
    }

    @Operation(description = "根据ID更新进门请求")
    @RequestMapping(value = "/in/update/", method = POST)
    AjaxResult updateById(@RequestBody Map<String, Object> mp) throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = InetAddress.getLocalHost().getHostAddress();
        String url = host + port + "/in/update/";
//        String url = "http://localhost:8088/in/update/";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @RequestMapping(value = "/in/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) throws UnknownHostException {

        RestTemplate restTemplate = new RestTemplate();
        String host = InetAddress.getLocalHost().getHostAddress();
        String url = host + port + "/in/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
//        String url = "http://localhost:8088/in/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
        Map<String,Object> mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        System.out.println(mp.size());
        return restTemplate.getForObject(url, AjaxResult.class, mp);

    }
}
