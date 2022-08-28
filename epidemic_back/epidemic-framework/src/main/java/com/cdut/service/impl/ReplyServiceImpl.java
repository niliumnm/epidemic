package com.cdut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.mapper.*;
import com.cdut.pojo.*;
import com.cdut.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 47345
 * @description 针对表【t_reply】的数据库操作Service实现
 * @createDate 2022-08-26 13:04:11
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
        implements ReplyService {

    @Autowired(required = false)
    private UserMapper userDao;

    @Autowired(required = false)
    private InRequestMapper inRequestMapper;

    @Autowired(required = false)
    private OutRequestMapper outRequestMapper;

    @Autowired(required = false)
    private VistorMapper vistorMapper;


    public User getUserById(Integer userId) {
        return userDao.getUserByID(userId);
    }

    public InRequest getInRequest(Integer requestId) {
        return inRequestMapper.selectById(requestId);
    }

    public OutRequest getOutRequest(Integer requestId) {

        return outRequestMapper.selectById(requestId);
    }

    public Vistor getVisRequest(Integer requestId) {
        return vistorMapper.selectById(requestId);
    }
}




