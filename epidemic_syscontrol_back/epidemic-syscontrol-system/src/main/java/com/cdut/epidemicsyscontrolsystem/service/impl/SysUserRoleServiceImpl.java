package com.cdut.epidemicsyscontrolsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsyscontrolcommon.utils.RedisCache;
import com.cdut.epidemicsyscontrolsystem.mapper.SysUserRoleMapper;
import com.cdut.epidemicsyscontrolsystem.pojo.LoginUser;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUser;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUserRole;
import com.cdut.epidemicsyscontrolsystem.service.SysUserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 47345
* @description 针对表【t_sys_user_role】的数据库操作Service实现
* @createDate 2022-08-29 11:01:38
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public List<String> getUserRoles(int id) {
        List<String> userRoles = userRoleMapper.getUserRoles(id);
        return userRoles;
    }

    @Override
    public Integer update(SysUser sysUser, Integer roleId) {
        Integer id = sysUser.getId();
        SysUserRole sysUserRole = userRoleMapper.selectById(id);
        System.out.println(sysUserRole.toString());
//        sysUserRole.setRoleId(roleId);
        if (roleId == 1) sysUserRole.setRoleName("admin");
        if (roleId == 2) sysUserRole.setRoleName("common");

        return userRoleMapper.update(sysUserRole);
    }

    @Override
    public Integer insert(SysUserRole sysUserRole) {
        return userRoleMapper.insert(sysUserRole);
    }
}




