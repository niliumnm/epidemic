package com.cdut.epidemicsystem.service;

import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.pojo.InRequest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 47345
* @description 针对表【t_in_request】的数据库操作Service
* @createDate 2022-08-26 13:04:11
*/
public interface InRequestService extends IService<InRequest> {

    AjaxResult postRequest(InRequest inRequest);

    List<InRequest> getPage(Integer pageNum, Integer pageSize, String name);
}
