package com.cdut.controller;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.pojo.OutRequest;
import com.cdut.service.impl.OutRequestServiceImpl;
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

    @Operation(description = "发送出门请求")
    @RequestMapping(value = "/out/post", method = POST)
    AjaxResult postRequest(@RequestBody OutRequest outRequest) {
        if (outRequest.getTemprature() == null || outRequest.getMask() == null || outRequest.getTrack() == null || outRequest.getHealthStatus() == null) {
            return AjaxResult.error("请完整填写表单");
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

}
