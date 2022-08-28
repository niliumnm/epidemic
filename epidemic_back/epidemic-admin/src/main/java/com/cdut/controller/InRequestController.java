package com.cdut.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.pojo.InRequest;
import com.cdut.service.InRequestService;
import com.cdut.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cdut.epidemic_common.utils.AjaxResult.Type.ERROR;
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
}
