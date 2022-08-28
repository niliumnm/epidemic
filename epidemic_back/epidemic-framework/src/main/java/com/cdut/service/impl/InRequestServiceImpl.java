package com.cdut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.mapper.UserMapper;
import com.cdut.pojo.InRequest;
import com.cdut.pojo.User;
import com.cdut.service.InRequestService;
import com.cdut.mapper.InRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 47345
* @description 针对表【t_in_request】的数据库操作Service实现
* @createDate 2022-08-26 13:04:11
*/
@Service
public class InRequestServiceImpl extends ServiceImpl<InRequestMapper, InRequest>
    implements InRequestService{

    @Autowired(required = false)
    InRequestMapper inRequestDao;
    @Autowired
    UserMapper userMapper;

    @Override
    public AjaxResult postRequest(InRequest inRequest) {
        User user = userMapper.getUserByID(inRequest.getUserId());
        inRequest.setName(user.getDisplayName());
        inRequest.setGender(user.getGender());
        inRequest.setMobile(user.getMobile());
        inRequest.setIdNum(user.getIdNum());
        inRequest.setHome(user.getHome());

        return AjaxResult.success("发送成功", inRequestDao.insert(inRequest));
    }
}




