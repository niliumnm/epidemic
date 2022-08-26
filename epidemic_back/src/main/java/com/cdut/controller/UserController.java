package com.cdut.controller;

import com.auth0.jwt.JWT;
import com.cdut.pojo.User;
import com.cdut.service.UserService;
import com.cdut.utils.JWTUtil;
import com.cdut.utils.MD5Util;
import com.cdut.utils.RedisUtil;
import com.cdut.utils.SaltUtils;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//http://localhost:8088/swagger-ui.html
@Api(tags = "UserController", description = "用户管理")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("获取所有用户列表")
    @RequestMapping(value = "/getAllUsers", method = GET)
    public List<User> getAll() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return userService.getAll();
    }

    @ApiOperation("新建用户")
    @RequestMapping(value = "/User", method = POST)
    public User insertUser(User user) {
        return new User();
    }

    @ApiOperation("删除用户")
    @DeleteMapping(value = "/user/{id}")
    public Integer delete(@PathVariable Integer id) {
        if(id==null||id<=0) return -0;
        return userService.deleteByID(id);
    }

    @ApiOperation("用户登出")
    @RequestMapping(value = "/user/logout", method = POST)
    public User logout(User user) {
        return new User();
    }

    @ApiOperation("修改用户")
    @RequestMapping(value = "/user/{id}", method = PUT)
    public User modifyUser(User user, @PathVariable("id") Integer userId) {
        System.out.println(userId);
        return new User();
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = POST)
    public String login(HttpServletResponse response, String username, String password, String validateCode, @RequestHeader String validateKey) {
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
                    return "登录成功";
                } else {
                    return "密码错误";
                }
            } else {
                return "用户名不存在";
            }
        }else {
            return "验证码错误";
        }


    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register",method = POST)
    public int register(@Param("username")String username,@Param("password")String password){
        User user = new User();
        user.setDisplayName(username);
        System.out.println(username);
        user.setPassword(password);

        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        System.out.println(user.getSalt());

        user.setPassword( MD5Util.formPassToDBPass(password, salt));
        System.out.println(user.toString());

        return userService.register(user);
    }

    @ApiOperation("更新用户")
    @RequestMapping(value = "/register",method = PUT)
    public int upDate(@RequestBody User user){

        if (user.getId() <= 0) {
            return -1;
        }

        return userService.update(user);
    }

    @RequestMapping("/test")
    public User test(User user){
        return new User();
    }
}
