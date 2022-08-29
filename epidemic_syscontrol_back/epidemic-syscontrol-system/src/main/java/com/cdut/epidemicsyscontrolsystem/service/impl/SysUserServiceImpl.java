package com.cdut.epidemicsyscontrolsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsyscontrolsystem.mapper.SysUserMapper;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUser;
import com.cdut.epidemicsyscontrolsystem.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 47345
* @description 针对表【t_sys_user】的数据库操作Service实现
* @createDate 2022-08-29 11:01:38
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUserByUsername(String username) {
        SysUser sysUser = sysUserMapper.getSysUserByUsername(username);
        return sysUser;
    }
}




