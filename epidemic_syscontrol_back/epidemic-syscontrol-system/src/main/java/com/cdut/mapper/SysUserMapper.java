package com.cdut.mapper;

import com.cdut.pojo.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 47345
* @description 针对表【t_sys_user】的数据库操作Mapper
* @createDate 2022-09-01 14:39:03
* @Entity com.cdut.epidemicsyscontrolsystem.pojo.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    int saveAvatarUrl(@Param("username") String username, @Param("avatar")String avatar);

    SysUser getSysUserByUsername(@Param("username") String username);

    String getAvatarByUsername(@Param("username")String username);

    Integer update(@Param("sysUser")SysUser sysUser);

    int insert(@Param("sysUser") SysUser sysUser);
}




