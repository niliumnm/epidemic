package com.cdut.controller;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.pojo.*;
import com.cdut.epidemicsystem.service.impl.ReplyServiceImpl;
import com.cdut.epidemicsystem.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Tag(name = "InRequestController", description = "回复请求")
public class ReplyController {
    @Autowired
    ReplyServiceImpl replyService;
    @Autowired
    UserServiceImpl userService;

    @Operation(description = "回复请求")
    @RequestMapping(value = "/rep/rep", method = POST)
    AjaxResult postRequest(@RequestParam("passed") Integer passed,
                           @RequestParam("summary") String summary,
                           @RequestParam("type") Integer type,
                           @RequestParam("requestId") Integer requestId) {
        Reply reply = new Reply();
        Integer userId=0;
        reply.setType(type);
        reply.setPassed(passed);
        reply.setSummary(summary);


        //HealthStatue

        Integer heathStatus=0;
        Integer mask = 0;
        Double temprature= 0.1;
        Integer requestID = 0;
        if (type == 1) {
            InRequest inRequest = replyService.getInRequest(requestId);
            heathStatus= inRequest.getHealthStatus();
            mask = inRequest.getMask();
            temprature = inRequest.getTemprature();
            userId = inRequest.getUserId();
            requestID = inRequest.getRequestId();
        } else if (type==2) {
            OutRequest outRequest = replyService.getOutRequest(requestId);
            heathStatus=outRequest.getHealthStatus();
            mask=outRequest.getMask();
            temprature = outRequest.getTemprature();
            userId = outRequest.getUserId();
            requestID = outRequest.getRequestId();
        } else if (type==3) {
            Vistor visRequest = replyService.getVisRequest(requestId);
            heathStatus= visRequest.getHealthStatus();
            mask = visRequest.getMask();
            temprature = visRequest.getTemprature();
            userId = visRequest.getUserId();
            requestID = visRequest.getRequestId();
        }
        User userById = replyService.getUserById(userId);
        reply.setName(userById.getDisplayName());
        reply.setMobile(userById.getMobile());
        reply.setHealthStatue(heathStatus);
        reply.setMask(mask);
        reply.setTemprature(temprature);
        reply.setUserId(userId);
        reply.setRequestId(requestID);

        return AjaxResult.success("回复成功", replyService.save(reply));
    }

    @Operation(description = "查看全部回复")
    @RequestMapping(value = "/rep/all", method = GET)
    AjaxResult postRequest() {
        return AjaxResult.success("查询成功", replyService.list());
    }

    @GetMapping("/rep/page")
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {

        List<Reply> replies = replyService.getPage(pageNum, pageSize, name);
        return AjaxResult.success(replies);
    }

    @GetMapping("/rep/time")
    public AjaxResult findTime(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String begin,
                               @RequestParam String end ){

        if(begin.compareTo(end)>=0){
            return AjaxResult.error("参数错误:起始日期大于截止日期!");
        }
        List<Reply> visRequests = replyService.getTime(pageNum, pageSize,begin,end);
        return AjaxResult.success(visRequests);
    }

}
