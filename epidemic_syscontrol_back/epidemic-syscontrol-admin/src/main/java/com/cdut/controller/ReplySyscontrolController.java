package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.mapper.SysUserMapper;
import com.cdut.pojo.LoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Tag(name = "InRequestController", description = "回复请求")
public class ReplySyscontrolController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${front.port}")
    private int port;
    @Value("${front.host}")
    private String host;


    @Autowired
    private SysUserMapper sysUserMapper;


    @Operation(description = "回复请求")
    @RequestMapping(value = "/rep/rep", method = POST)
    AjaxResult postRequest(@RequestParam("passed") Integer passed,
                           @RequestParam("summary") String summary,
                           @RequestParam("type") Integer type,
                           @RequestParam("requestId") Integer requestId) throws UnknownHostException {
        LoginUser loginUser = SecurityUtil.getLoginUser();
        Integer sysUserId = loginUser.getId();
        Integer department = loginUser.getUser().getDepartment();
        System.out.println("sysReply: " + sysUserId);

        MultiValueMap<String,Object> mp = new LinkedMultiValueMap<>();
        mp.add("passed", passed);
        mp.add("summary", summary);
        mp.add("type", type);
        mp.add("requestId", requestId);
        mp.add("department", department);
        String host = "http://"+ this.host + ":";
        RestTemplate restTemplate = new RestTemplate();
        String url = host + port + "/rep/rep";
//        String url = "http://localhost:8088/rep/rep";
        AjaxResult result = restTemplate.postForObject(url, mp, AjaxResult.class);
//        SysUser me = sysUserMapper.selectById(sysUserId);
        System.out.println(result);
//        LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) result.get(AjaxResult.DATA_TAG);
//        User user = (User) hashMap.get(AjaxResult.DATA_TAG);
        //鉴定权限

        return result;


    }


    @Operation(description = "查看全部回复")
    @RequestMapping(value = "/rep/all", method = GET)
    AjaxResult postRequest() throws UnknownHostException {
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/rep/all";
        log.info(url);
//        String url = "http://localhost:8088/rep/all";
        return restTemplate.getForObject(url, AjaxResult.class);
    }

    @RequestMapping (value = "/rep/page",method = GET)
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) throws UnknownHostException {

        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/rep/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
//        String url = "http://localhost:8088/rep/page?pageNum={pageNum}&pageSize={pageSize}&name={name}";
        Map<String,Object> mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("name", name);
        return restTemplate.getForObject(url, AjaxResult.class, mp);
    }

    @GetMapping("/rep/time")
    public AjaxResult findByTime(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam String begin,
            @RequestParam String end){
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://"+ this.host + ":";
        String url = host + port + "/rep/time?pageNum={pageNum}&pageSize={pageSize}&begin={begin}&end={end}";
        Map<String,Object> mp = new HashMap<>();
        mp.put("pageNum", pageNum);
        mp.put("pageSize", pageSize);
        mp.put("begin", begin);
        mp.put("end", end);
        return restTemplate.getForObject(url, AjaxResult.class, mp);
    }

}
