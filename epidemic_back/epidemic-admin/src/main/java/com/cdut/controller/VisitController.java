package com.cdut.controller;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.pojo.OutRequest;
import com.cdut.epidemicsystem.pojo.Vistor;
import com.cdut.epidemicsystem.service.impl.UserServiceImpl;
import com.cdut.epidemicsystem.service.impl.VistorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Tag(name = "OutRequestController", description = "访问请求")

public class VisitController {
    @Autowired
    VistorServiceImpl vistorService;
    @Autowired
    UserServiceImpl userService;

    @Operation(description = "发送外来请求")
    @RequestMapping(value = "/vis/post", method = POST)
    AjaxResult postRequest(@RequestBody Vistor vistorRequest) {
        if (vistorRequest.getTemprature()==null||vistorRequest.getHealthStatus()==null||vistorRequest.getMask()==null||vistorRequest.getDangerZone()==null) {
            return AjaxResult.error("请完整填写表单");
        }
        if (userService.getUserByID(vistorRequest.getUserId()) == null) {
            return AjaxResult.error("用户ID不存在!");
        }
        if (vistorRequest.getUserId()!=null) {
            return AjaxResult.success("请求成功",vistorService.postRequest(vistorRequest));
        }
        return AjaxResult.error("未传入用户ID");
    }

    @Operation(description = "根据UserId查所有外来请求")
    @RequestMapping(value = "/vis/all/{userid}", method = GET)
    AjaxResult getAllVisById(@PathVariable("userid") Integer userid) {
        if (userid == null || userid <= 0) {
            return AjaxResult.error("UserID错误");
        }
        return AjaxResult.success("查询成功", vistorService.getAllVisById(userid));
    }

    @Operation(description = "撤销外来请求")
    @RequestMapping(value = "/vis/del", method = DELETE)
    AjaxResult delRequest(@RequestParam Integer id) {
        if (id==null||id<=0) {
            return AjaxResult.error("请求错误");
        }
        return AjaxResult.success("撤销成功",vistorService.removeById(id));
    }

    @Operation(description = "领导查询所有访客来访请求")
    @RequestMapping(value = "/vis/all", method = GET)
    AjaxResult getAll() {
        List<Vistor> res = vistorService.list();
        return AjaxResult.success("查询成功", res);
    }

    @Operation(description = "根据ID更新访客请求")
    @RequestMapping(value = "/vis/update/", method = POST)
    AjaxResult updateById(@RequestBody Vistor vistor) {
        return AjaxResult.success("更新成功,如果记录不存在则被创建", vistorService.saveOrUpdate(vistor));
    }

}
