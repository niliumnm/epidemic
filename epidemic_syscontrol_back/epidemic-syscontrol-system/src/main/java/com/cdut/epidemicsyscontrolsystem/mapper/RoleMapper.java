package com.cdut.epidemicsyscontrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdut.epidemicsyscontrolsystem.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 47345
* @description 针对表【t_role】的数据库操作Mapper
* @createDate 2022-08-29 11:01:38
* @Entity com.cdut.epidemicsystem.pojo.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}




