package com.cdut.epidemicsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsystem.mapper.UserMapper;
import com.cdut.epidemicsystem.pojo.OutRequest;
import com.cdut.epidemicsystem.pojo.User;
import com.cdut.epidemicsystem.service.OutRequestService;
import com.cdut.epidemicsystem.mapper.OutRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 47345
 * @description 针对表【t_out_request】的数据库操作Service实现
 * @createDate 2022-08-26 13:04:11
 */
@Service
public class OutRequestServiceImpl extends ServiceImpl<OutRequestMapper, OutRequest>
        implements OutRequestService {

    @Autowired
    OutRequestMapper outRequestDao;

    @Autowired
    UserMapper userMapper;

    public int postRequest(OutRequest outRequest) {
        User user = userMapper.getUserByID(outRequest.getUserId());
        outRequest.setName(user.getDisplayName());
        outRequest.setIdNum(user.getIdNum());
        outRequest.setMobile(user.getMobile());
        outRequest.setHome(user.getHome());
        return outRequestDao.insert(outRequest);
    }

    public List<OutRequest> getAllOutReqById(Integer id) {
        QueryWrapper<OutRequest> listQueryWrapper = new QueryWrapper<>();
        listQueryWrapper.eq("user_id", id);
        return outRequestDao.selectList(listQueryWrapper);
    }
}




