package com.cdut.epidemicsyscontrolsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsyscontrolsystem.mapper.SysUserRoleMapper;
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

    @Override
    public List<String> getUserRoles(int id) {
        List<String> userRoles = userRoleMapper.getUserRoles(id);
        return userRoles;
    }
}




