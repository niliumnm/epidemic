package com.cdut.epidemicsyscontrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUser;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUserRole;


import java.util.List;

/**
* @author 47345
* @description 针对表【t_sys_user_role】的数据库操作Service
* @createDate 2022-08-29 11:01:38
*/
public interface SysUserRoleService extends IService<SysUserRole> {

    List<String> getUserRoles(int id);

    Integer update(SysUser sysUser, Integer roleId);

}
