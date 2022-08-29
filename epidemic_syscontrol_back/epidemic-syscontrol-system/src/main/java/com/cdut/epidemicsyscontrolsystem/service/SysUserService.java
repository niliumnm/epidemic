package com.cdut.epidemicsyscontrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdut.epidemicsyscontrolsystem.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

/**
* @author 47345
* @description 针对表【t_sys_user】的数据库操作Service
* @createDate 2022-08-29 11:01:38
*/
public interface SysUserService extends IService<SysUser> {
    public SysUser getSysUserByUsername(@Param("username") String username);
}
