package com.cdut.controller;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.pojo.*;
import com.cdut.service.ReplyService;
import com.cdut.service.impl.ReplyServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Tag(name = "InRequestController", description = "回复请求")
public class ReplyController {
    @Autowired
    ReplyServiceImpl replyService;

    @Operation(description = "回复请求")
    @RequestMapping(value = "/rep/rep", method = POST)
    AjaxResult postRequest(@RequestParam("userId") Integer userId,
                           @RequestParam("passed") Integer passed,
                           @RequestParam("summary") String summary,
                           @RequestParam("type") Integer type,
                           @RequestParam("requestId") Integer requestId) {
        Reply reply = new Reply();
        reply.setUserId(userId);
        reply.setType(type);
        reply.setPassed(passed);
        reply.setSummary(summary);
        User userById = replyService.getUserById(userId);
        reply.setName(userById.getDisplayName());
        reply.setMobile(userById.getMobile());

        //HealthStatue

        Integer heathStatus=0;
        Integer mask = 0;
        Double temprature= 0.1;
        if (type == 1) {
            InRequest inRequest = replyService.getInRequest(requestId);
            heathStatus= inRequest.getHealthStatus();
            mask = inRequest.getMask();
            temprature = inRequest.getTemprature();
        } else if (type==2) {
            OutRequest outRequest = replyService.getOutRequest(requestId);
            heathStatus=outRequest.getHealthStatus();
            mask=outRequest.getMask();
            temprature = outRequest.getTemprature();
        } else if (type==3) {
            Vistor visRequest = replyService.getVisRequest(requestId);
            heathStatus= visRequest.getHealthStatus();
            mask = visRequest.getMask();
            temprature = visRequest.getTemprature();
        }
        reply.setHealthStatue(heathStatus);
        reply.setMask(mask);
        reply.setTemprature(temprature);

        return AjaxResult.success("回复成功", replyService.save(reply));
    }

    @Operation(description = "查看全部回复")
    @RequestMapping(value = "/rep/all", method = GET)
    AjaxResult postRequest() {
        return AjaxResult.success("查询成功", replyService.list());
    }

}
