package com.cdut.controller;

import com.cdut.epidemicsyscontrolcommon.utils.AjaxResult;
import com.cdut.epidemicsyscontrolcommon.utils.RedisCache;
import com.cdut.epidemicsyscontrolframework.security.SecurityUtil;
import com.cdut.pojo.LoginUser;
import com.cdut.pojo.SysUser;
import com.cdut.service.SysUserRoleService;
import com.cdut.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

// TODO: 2022/9/1 系统用户信息相关的接口
@RestController
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserRoleService sysUserRoleService;

    @Autowired
    RedisCache redisCache;


    private void updateRedisMes(SysUser user){
        Integer id = user.getId();
        LoginUser loginUser = new LoginUser(id, new HashSet<>(sysUserRoleService.getUserRoles(id)), user);
        redisCache.setCacheObject(user.getUsername(),loginUser);
    }

    /**
     * 获取自身信息
     * @return
     */
    @GetMapping("/sysuser/info")
    public AjaxResult info(){
        LoginUser loginUser = SecurityUtil.getLoginUser();
        SysUser user = loginUser.getUser();
        user.setPassword(null);
        user.setSalt(null);
        user.setAvatarUrl(null);
        loginUser.setUser(user);
        return AjaxResult.success("管理员信息查询成功",loginUser);
    }

    @GetMapping("/sysuser/otherInfo")
    public AjaxResult otherInfo(@RequestParam("username")String username){
        SysUser user = sysUserService.getSysUserByUsername(username);
        List<String> userRoles = sysUserRoleService.getUserRoles(user.getId());
        user.setPassword(null);
        user.setSalt(null);
        user.setAvatarUrl(null);
        LoginUser loginUser = new LoginUser(user.getId(), new HashSet<>(userRoles), user);
        return AjaxResult.success("查询成功",loginUser);
    }


    // TODO: 2022/9/1 更新管理员信息
    @RequestMapping(value = "/sysuser/update",method = POST)
    public AjaxResult updateInfo(@RequestBody SysUser sysUser) {
        SysUser sysUser1 = SecurityUtil.getLoginUser().getUser();

        if (sysUser1.getId() < 0) return AjaxResult.error("没有此用户");
        sysUser.setId(sysUser1.getId());
        sysUser.setUsername(sysUser1.getUsername());
        sysUserService.update(sysUser);
        SysUser sysUser2 = sysUserService.getById(sysUser1.getId());
        // 重新设置redis信息
        updateRedisMes(sysUser2);
        sysUser2.setPassword(null);
        sysUser2.setSalt(null);
        sysUser2.setAvatarUrl(null);
        return AjaxResult.success("更新成功", sysUser2);
    }

    // TODO: 2022/9/1 更改管理员权限
    @RequestMapping(value = "/sysuser/updaterole",method = POST)
    @PreAuthorize("@ps.hasPermission('admin')")
    public AjaxResult updateRole(@RequestParam("username") String username, @RequestParam("roleId")Integer roleId){
        SysUser sysUser = sysUserService.getSysUserByUsername(username);
        if (sysUser.getId() <= 0) return AjaxResult.error("不存在此用户",-1);
        return AjaxResult.success("更新成功", sysUserRoleService.update(sysUser, roleId));
    }

    @RequestMapping(value = "/sysuser/updateroleself",method = POST)
    @PreAuthorize("@ps.hasPermission('admin')")
    public AjaxResult updateRoleSelf(@RequestParam("roleId")Integer roleId){
        SysUser sysUser = SecurityUtil.getLoginUser().getUser();
        if (sysUser.getId() <= 0) return AjaxResult.error("不存在此用户",-1);
        return AjaxResult.success("更新成功", sysUserRoleService.update(sysUser, roleId));
    }


    // TODO: 2022/9/1 更改管理员密码
    public AjaxResult changePassword(){
        return null;
    }

}