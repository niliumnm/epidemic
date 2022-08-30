package com.cdut.epidemicsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsystem.mapper.UserMapper;
import com.cdut.epidemicsystem.mapper.VistorMapper;
import com.cdut.epidemicsystem.pojo.InRequest;
import com.cdut.epidemicsystem.pojo.User;
import com.cdut.epidemicsystem.service.VistorService;
import com.cdut.epidemicsystem.pojo.Vistor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 47345
* @description 针对表【t_vistor】的数据库操作Service实现
* @createDate 2022-08-26 13:04:12
*/
@Service
public class VistorServiceImpl extends ServiceImpl<VistorMapper, Vistor>
    implements VistorService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VistorMapper vistorMapper;

    public Integer postRequest(Vistor vistorRequest) {
        User user = userMapper.getUserByID(vistorRequest.getUserId());
        vistorRequest.setName(user.getDisplayName());
        vistorRequest.setGender(user.getGender());
        vistorRequest.setMobile(user.getMobile());
        vistorRequest.setIdNum(user.getIdNum());
        vistorRequest.setHome(user.getHome());
        return vistorMapper.insert(vistorRequest);
    }

    public List<Vistor> getAllVisById(Integer userid) {
        QueryWrapper<Vistor> listQueryWrapper = new QueryWrapper<>();
        listQueryWrapper.eq("user_id", userid);
        return vistorMapper.selectList(listQueryWrapper);
    }

    public List<Vistor> getPage(Integer pageNum, Integer pageSize, String name) {
        pageNum = (pageNum - 1) * pageSize;
        QueryWrapper<Vistor> queryWrapper = new QueryWrapper<>();
        if (!(name.equals(""))){
            queryWrapper.like("name", name);

        }

        queryWrapper.last("limit "  + pageNum + ", " + pageSize);
        List<Vistor> vistorList = vistorMapper.selectList(queryWrapper);
        return vistorList;
    }
}




