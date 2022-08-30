package com.cdut.controller;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.pojo.InRequest;
import com.cdut.epidemicsystem.pojo.OutRequest;
import com.cdut.epidemicsystem.service.impl.OutRequestServiceImpl;
import com.cdut.epidemicsystem.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Tag(name = "OutRequestController", description = "出门请求")
public class OutRequeController {
    @Autowired
    OutRequestServiceImpl outRequestService;

    @Autowired
    UserServiceImpl userService;

    @Operation(description = "发送出门请求")
    @RequestMapping(value = "/out/post", method = POST)
    AjaxResult postRequest(@RequestBody OutRequest outRequest) {
        if (outRequest.getTemprature() == null || outRequest.getMask() == null || outRequest.getTrack() == null || outRequest.getHealthStatus() == null) {
            return AjaxResult.error("请完整填写表单");
        }
        if (userService.getUserByID(outRequest.getUserId()) == null) {
            return AjaxResult.error("用户ID不存在!");
        }
        if (outRequest.getUserId() != null) {
            return AjaxResult.success("请求成功",outRequestService.postRequest(outRequest));
        }
        return AjaxResult.error("未传入用户ID");
    }

    @Operation(description = "撤销出门请求")
    @RequestMapping(value = "/out/del", method = DELETE)
    AjaxResult postRequest(@RequestParam Integer id) {
        return AjaxResult.success("删除成功",outRequestService.removeById(id));
    }

    @Operation(description = "根据ID查询所有出门请求")
    @RequestMapping(value = "/out/all/{userid}", method = GET)
    AjaxResult getAllOutReqById(@PathVariable Integer userid) {
        return AjaxResult.success("查询成功", outRequestService.getAllOutReqById(userid));
    }

    @Operation(description = "领导查询所有出门请求")
    @RequestMapping(value = "/out/all", method = GET)
    AjaxResult getAll() {
        List<OutRequest> res = outRequestService.list();
        return AjaxResult.success("查询成功", res);
    }

    @Operation(description = "根据ID更新出门请求")
    @RequestMapping(value = "/out/update/", method = POST)
    AjaxResult updateById(@RequestBody OutRequest outRequest) {
        return AjaxResult.success("更新成功,如果记录不存在则被创建", outRequestService.saveOrUpdate(outRequest));
    }

    @GetMapping("/out/page")
    public AjaxResult findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name
    ) {

        List<OutRequest> outRequests = outRequestService.getPage(pageNum, pageSize, name);
        return AjaxResult.success(outRequests);
    }


}
