package com.cdut.epidemicsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemic_common.utils.MD5Util;
import com.cdut.epidemic_common.utils.Page;
import com.cdut.epidemicsystem.mapper.DepartmentMapper;
import com.cdut.epidemicsystem.mapper.UserMapper;
import com.cdut.epidemicsystem.pojo.Department;
import com.cdut.epidemicsystem.pojo.User;
import com.cdut.epidemicsystem.pojo.dto.UserDto;
import com.cdut.epidemicsystem.service.DepartmentService;
import com.cdut.epidemicsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 47345
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-08-26 13:04:12
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<UserMapper, User>
    implements DepartmentService {

    @Autowired(required = false)
    private DepartmentMapper departmentDao;

    @Override
    public Department getDepartmentByID(int id) {
        return departmentDao.getDepartmentByID(id);
    }


}




