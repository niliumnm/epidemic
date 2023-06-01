package com.cdut.service;

import com.cdut.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdut.pojo.dto.SysUserDto;
import org.apache.ibatis.annotations.Param;

/**
* @author 47345
* @description 针对表【t_sys_user】的数据库操作Service
* @createDate 2022-09-01 14:39:03
*/
public interface SysUserService extends IService<SysUser> {
    int saveAvatarUrl(String username, String avatar);

    SysUser getSysUserByUsername(String username);

    String getAvatarByUsername(@Param("username")String username);

    SysUserDto rigister(SysUser sysUser);

    Integer update(SysUser sysUser);
}
