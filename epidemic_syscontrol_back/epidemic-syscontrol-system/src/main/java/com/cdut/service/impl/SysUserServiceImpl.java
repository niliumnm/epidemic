package com.cdut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemicsyscontrolcommon.utils.MD5Util;
import com.cdut.mapper.SysUserRoleMapper;
import com.cdut.pojo.SysUser;
import com.cdut.pojo.SysUserRole;
import com.cdut.pojo.dto.SysUserDto;
import com.cdut.service.SysUserService;
import com.cdut.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 47345
* @description 针对表【t_sys_user】的数据库操作Service实现
* @createDate 2022-09-01 14:39:03
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;


    @Autowired(required = false)
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int saveAvatarUrl(String username, String avatar) {
        return sysUserMapper.saveAvatarUrl(username, avatar);
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        return sysUserMapper.getSysUserByUsername(username);
    }

    @Override
    public String getAvatarByUsername(String username) {
        return sysUserMapper.getAvatarByUsername(username);
    }

    @Override
    public SysUserDto rigister(SysUser sysUser) {
        SysUserDto sysUserDto = new SysUserDto( sysUser.getId(),
                sysUser.getUsername(),
                sysUser.getAddress(),
                sysUser.getIdCardNum(),
                sysUser.getPhone(),
                sysUser.getRealName());
        System.out.println(sysUser.toString());
        sysUserMapper.insert(sysUser);
        sysUser = sysUserMapper.getSysUserByUsername(sysUser.getUsername());
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setRoleId(2);
        sysUserRole.setUsername(sysUser.getUsername());
        sysUserRole.setRoleName("common");
        sysUserRoleMapper.insert(sysUserRole);
        return sysUserDto;
    }

    @Override
    public Integer update(SysUser sysUser) {
        if (sysUser.getPassword() != null) {
            String password  = sysUser.getPassword();
            String salt = sysUser.getSalt();
            sysUser.setPassword(MD5Util.formPassToDBPass(password, salt));
        }
        System.out.println(sysUser);
        return sysUserMapper.update(sysUser);
    }
}




