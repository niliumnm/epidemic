package com.cdut.controller;


import com.cdut.epidemic_common.utils.*;
import com.cdut.pojo.User;

import com.cdut.epidemic_common.utils.JWTUtil;
import com.cdut.epidemic_common.utils.MD5Util;
import com.cdut.epidemic_common.utils.RedisUtil;
import com.cdut.epidemic_common.utils.SaltUtils;

import com.cdut.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//http://localhost:8088/swagger-ui.html
@Tag(name = "UserController", description = "用户管理")
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    private RedisUtil redisUtil;

    @Operation(description = "获取所有用户列表")
    @RequestMapping(value = "/getAllUsers", method = GET)
    public AjaxResult getAll() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return AjaxResult.success("所有用户获取成功",userService.getAll());
    }

    @Operation(description = "新建用户")
    @RequestMapping(value = "/User", method = POST)
    public AjaxResult insertUser(User user) {
        return AjaxResult.success("新建成功",new User());
    }

    @Operation(description = "删除用户")
    @DeleteMapping(value = "/user/{id}")
    public AjaxResult delete(@PathVariable Integer id) {
        if(id==null||id<=0) return AjaxResult.error("删除失败",-0);
        return AjaxResult.success("删除成功",userService.deleteByID(id));
    }

    @Operation(description = "用户登出")
    @RequestMapping(value = "/user/logout", method = POST)
    public AjaxResult logout(User user) {
        return AjaxResult.success("登出成功",new User());
    }

    @Operation(description = "修改用户")
    @RequestMapping(value = "/user/{id}", method = PUT)
    public AjaxResult modifyUser(User user, @PathVariable("id") Integer userId) {
        System.out.println(userId);
        return AjaxResult.success("修改成功" ,new User());
    }

    @Operation(description = "用户登录")
    @RequestMapping(value = "/login", method = POST)
    public AjaxResult login(HttpServletResponse response, String username, String password, String validateCode, @RequestHeader String validateKey) {
        String validateCodeRedis = (String) redisUtil.get(validateKey);
        System.out.println("1:"+validateCodeRedis);
        System.out.println("2:"+validateCode);
        if (validateCodeRedis.equals(validateCode)) {
            User user = userService.findByName(username);
            if (user != null) {
                String salt = user.getSalt();
                String finPassword = MD5Util.formPassToDBPass(password, salt);

                if (finPassword.equals(user.getPassword())) {
                    String token = JWTUtil.sign(user.getDisplayName(), user.getPassword());
                    response.setHeader("token", token);
                    return AjaxResult.success("登录成功");
                } else {
                    return AjaxResult.error("密码错误");
                }
            } else {
                return AjaxResult.error("用户名不存在");
            }
        }else {
            return AjaxResult.error("验证码错误");
        }


    }

    @Operation(description = "用户注册")
    @RequestMapping(value = "/register",method = POST)
    public AjaxResult register(@Param("username")String username,@Param("password")String password){
        User user = new User();
        user.setDisplayName(username);
        System.out.println(username);
        user.setPassword(password);

        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        System.out.println(user.getSalt());

        user.setPassword( MD5Util.formPassToDBPass(password, salt));
        System.out.println(user.toString());

        return AjaxResult.success("注册成功", userService.register(user));
    }

    @Operation(description = "更新用户")
    @RequestMapping(value = "/register",method = PUT)
    public AjaxResult upDate(@RequestBody User user){

        if (user.getId() <= 0) {
            return AjaxResult.error("不存在该用户", -1);
        }

        int i = userService.update(user);
        return AjaxResult.success("更新成功", i);
    }

    @RequestMapping("/test")
    public AjaxResult test(User user){
        return AjaxResult.success("测试成功", new User());
    }
}
