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
@Tag(name = "OutRequestController", description = "出门请求")
public class OutRequestSyscontrolController {

    @Operation(description = "发送出门请求")
    @RequestMapping(value = "/out/post", method = POST)
    AjaxResult postRequest(@RequestBody Map<String,Object> mp) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/out/post";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @Operation(description = "撤销出门请求")
    @RequestMapping(value = "/out/del", method = DELETE)
    AjaxResult postRequest(@RequestParam Integer id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/out/del?id={id}";
        restTemplate.delete(url, id);
        return AjaxResult.success("删除成功",1);
    }

    @Operation(description = "根据ID查询所有出门请求")
    @RequestMapping(value = "/out/all/{userid}", method = GET)
    AjaxResult getAllOutReqById(@PathVariable("userid") Integer userid) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/out/all/{userid}";
        return restTemplate.getForObject(url, AjaxResult.class, userid);
    }

    @Operation(description = "领导查询所有出门请求")
    @RequestMapping(value = "/out/all", method = GET)
    AjaxResult getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/out/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @Operation(description = "根据ID更新出门请求")
    @RequestMapping(value = "/out/update/", method = POST)
    AjaxResult updateById(@RequestBody Map<String,Object>mp) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/out/update/";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @RequestMapping(value = "/out/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/out/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
        Map<String,Object> mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        return restTemplate.getForObject(url, AjaxResult.class, mp);

    }


}
