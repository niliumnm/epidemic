package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Tag(name = "InRequestController", description = "回复请求")
public class ReplySyscontrolController {

    @Operation(description = "回复请求")
    @RequestMapping(value = "/rep/rep", method = POST)
    AjaxResult postRequest(@RequestParam("passed") Integer passed,
                           @RequestParam("summary") String summary,
                           @RequestParam("type") Integer type,
                           @RequestParam("requestId") Integer requestId) {
        Map<String,Object> mp = new HashMap<>();
        mp.put("passed", passed);
        mp.put("summary", summary);
        mp.put("type", type);
        mp.put("requestId", requestId);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rep/rep";
        return restTemplate.postForObject(url, mp, AjaxResult.class);
    }

    @Operation(description = "查看全部回复")
    @RequestMapping(value = "/rep/all", method = GET)
    AjaxResult postRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rep/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @RequestMapping (value = "/rep/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rep/page";
        Map mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        return restTemplate.getForObject(url, AjaxResult.class, mp);
    }


}
