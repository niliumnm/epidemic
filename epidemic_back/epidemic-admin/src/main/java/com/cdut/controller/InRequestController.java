package com.cdut.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.pojo.InRequest;
import com.cdut.epidemicsystem.service.InRequestService;
import com.cdut.epidemicsystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Tag(name = "InRequestController", description = "进门请求")

public class InRequestController {
    @Autowired
    InRequestService inRequestService;
    @Autowired
    UserService userService;

    @Operation(description = "发送进门请求")
    @RequestMapping(value = "/in/post", method = POST)
    AjaxResult postRequest(@RequestBody InRequest inRequest) {
        if (inRequest.getTemprature()==null||inRequest.getHealthStatus()==null||inRequest.getMask()==null||inRequest.getDangerZone()==null) {
            return AjaxResult.error("请完整填写表单");
        }
        if (inRequest.getUserId() != null) {
            if (userService.getUserByID(inRequest.getUserId()) == null) {
                return AjaxResult.error("用户ID不存在!");
            }
            return inRequestService.postRequest(inRequest);
        } return AjaxResult.error("请求错误");
    }

    @Operation(description = "撤销进门请求")
    @RequestMapping(value = "/in/del", method = DELETE)
    AjaxResult delRequest(@RequestParam Integer id) {
        if (id==null||id<=0) {
            return AjaxResult.error("请求错误");
        }
        return AjaxResult.success("撤销成功",inRequestService.removeById(id));
    }

    @Operation(description = "领导查询所有进门请求")
    @RequestMapping(value = "/in/all", method = GET)
    AjaxResult getAll() {
        List<InRequest> res = inRequestService.list();
        return AjaxResult.success("查询成功", res);
    }

    @Operation(description = "根据ID查询所有进门请求")
    @RequestMapping(value = "/in/all/{userid}", method = GET)
    AjaxResult getAllById(@PathVariable("userid") Integer userId) {
        QueryWrapper<InRequest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<InRequest> list = inRequestService.list(queryWrapper);
        return AjaxResult.success("查询成功", list);
    }

    @Operation(description = "根据ID更新进门请求")
    @RequestMapping(value = "/in/update/", method = POST)
    AjaxResult updateById(@RequestBody InRequest inRequest) {
        return AjaxResult.success("更新成功,如果记录不存在则被创建", inRequestService.saveOrUpdate(inRequest));
    }

    @GetMapping("/in/page")
    public AjaxResult findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name
    ) {

        List<InRequest> inRequests = inRequestService.getPage(pageNum, pageSize, name);
        return AjaxResult.success(inRequests);
    }
}
