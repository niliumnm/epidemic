package com.cdut.epidemicsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsystem.mapper.*;
import com.cdut.epidemicsystem.pojo.*;
import com.cdut.epidemicsystem.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private ReplyMapper replyMapper;


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

    public List<Reply> getPage(Integer pageNum, Integer pageSize, String name) {
        pageNum = (pageNum - 1) * pageSize;
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        if (!(name.equals(""))){
            queryWrapper.like("name", name);

        }

        queryWrapper.last("limit "  + pageNum + ", " + pageSize);
        List<Reply> replies = replyMapper.selectList(queryWrapper);
        return replies;
    }

    public List<Reply> getTime(Integer pageNum, Integer pageSize, String begin, String end) {
        pageNum = (pageNum - 1) * pageSize;
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("time", begin, end);
        queryWrapper.last("limit " + pageNum + ", " + pageSize);
        return replyMapper.selectList(queryWrapper);
    }

}




