package com.cdut.epidemicsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.cdut.epidemicsystem.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 47345
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-08-26 13:04:12
* @Entity com.cdut.pojo.User
*/
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    Department getDepartmentByID(@Param("id")int id);

}




