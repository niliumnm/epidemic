package com.cdut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdut.pojo.Department;

/**
* @author 47345
* @description 针对表【t_department】的数据库操作Service
* @createDate 2022-08-26 13:04:12
*/
public interface DepartmentService extends IService<Department>{

    public Department getDepartmentByID(int id);

}
