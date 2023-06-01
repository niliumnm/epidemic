package com.cdut.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.pojo.*;
import com.cdut.epidemicsystem.service.impl.ReplyServiceImpl;
import com.cdut.epidemicsystem.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Tag(name = "InRequestController", description = "回复请求")

public class ReplyController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ReplyServiceImpl replyService;
    @Autowired
    UserServiceImpl userService;

    @Operation(description = "回复请求")

    @RequestMapping(value = "/rep/rep", method = POST)
    AjaxResult postRequest(@RequestParam("passed") Integer passed,
                           @RequestParam("summary") String summary,
                           @RequestParam("type") Integer type,
                           @RequestParam("requestId") Integer requestId,
                           @RequestParam("sysUserId") Integer sysUserId) {
        System.out.println("front Reply:" + sysUserId);
        return replyService.postRequest(passed, summary, type, requestId, sysUserId);
    }

    @Operation(description = "请求查回复")
    @RequestMapping(value = "/rep/status", method = GET)
    AjaxResult postRequest(@RequestParam("type") Integer type,
                           @RequestParam("requestId") Integer requestId) {
        int status=0;
        QueryWrapper<Reply>qw=new QueryWrapper<Reply>();
        qw.eq("type", type );
        qw.eq("request_id", requestId );
        Reply reply=replyService.getOne(qw);
        System.out.println(reply);
        if(reply==null){
            return AjaxResult.success("审核中", reply);
        }else if(reply.getPassed()==1){
            return AjaxResult.success("已通过",reply);
        }else {
            return AjaxResult.success("已拒绝", reply);
        }
    }


    @Operation(description = "查看全部回复")
    @RequestMapping(value = "/rep/all", method = GET)
    AjaxResult postRequest() {
        log.info("进入user_system，postRequest方法");
        return AjaxResult.success("查询成功", replyService.list());
    }

    @Operation(description = "用户ID查行程")
    @RequestMapping(value = "/rep/trav", method = GET)
    AjaxResult getTrav(@RequestParam("id")Integer id) {
        List<Reply> list = replyService.getList(id);
        return AjaxResult.success("查询成功", list);
    }

    @Operation(description = "更新请求状态")
    @RequestMapping(value = "/rep/uppass", method = POST)
    AjaxResult uppass(@RequestParam("reply_id") Integer id,
                      @RequestParam("passed")Integer passed) {
        Reply reply = replyService.getById(id);
        if (reply==null){
            return AjaxResult.error("没有这条记录!");
        }
        reply.setPassed(passed);
        return AjaxResult.success("更新成功", replyService.saveOrUpdate(reply));
    }

    @Operation(description = "更新回复(可新建 不推荐)")
    @RequestMapping(value = "/rep/uprep", method = POST)
    AjaxResult uppass(@RequestBody Reply reply) {
        return AjaxResult.success("更新成功", replyService.saveOrUpdate(reply));
    }

    @Operation(description = "rep_id查回复")
    @RequestMapping(value = "/rep/findId/{rep_id}", method = GET)
    AjaxResult uppass(@PathVariable("rep_id")String id) {
        Reply byId = replyService.getById(id);
        if (byId==null){
            return AjaxResult.error("记录不存在");
        }
        return AjaxResult.success("查询成功", byId);
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
                               @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date begin,
                               @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end ){

        if(begin.compareTo(end)>=0){
            return AjaxResult.error("参数错误:起始日期大于截止日期!");
        }
        List<Reply> visRequests = replyService.getTime(pageNum, pageSize,begin,end);
        return AjaxResult.success(visRequests);
    }

}
