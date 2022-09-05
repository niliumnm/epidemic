package com.cdut.epidemicsyscontrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* @author 47345
* @description 针对表【t_sys_user_role】的数据库操作Mapper
* @createDate 2022-08-29 11:01:38
* @Entity com.cdut.epidemicsystem.pojo.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    List<String> getUserRoles(@Param("id") int id);

    Integer update(@Param("sysUserRole") SysUserRole sysUserRole);

    int insert(@Param("sysUserRole") SysUserRole sysUserRole);

}




