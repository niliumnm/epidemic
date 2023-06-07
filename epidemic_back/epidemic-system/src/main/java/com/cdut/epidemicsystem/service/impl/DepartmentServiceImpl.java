package com.cdut.epidemicsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cdut.epidemicsystem.mapper.DepartmentMapper;
import com.cdut.epidemicsystem.pojo.Department;
import com.cdut.epidemicsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 47345
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-08-26 13:04:12
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService {

    @Autowired(required = false)
    private DepartmentMapper departmentDao;

    @Override
    public Department getDepartmentByID(int id) {
        return departmentDao.getDepartmentByID(id);
    }


}




