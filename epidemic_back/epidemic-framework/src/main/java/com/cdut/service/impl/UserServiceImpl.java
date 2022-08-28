package com.cdut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemic_common.utils.JWTUtil;
import com.cdut.epidemic_common.utils.MD5Util;
import com.cdut.epidemic_common.utils.Page;
import com.cdut.pojo.User;
import com.cdut.pojo.dto.UserDto;
import com.cdut.service.UserService;
import com.cdut.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 47345
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-08-26 13:04:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired(required = false)
    private UserMapper userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public UserDto register(User user) {
        System.out.println(user.toString());
        UserDto userDto = new UserDto(user.getId(), user.getDisplayName(), user.getGender(), user.getIdNum(), user.getMobile(), user.getHome());
        userDao.insert(user);
        return userDto;
    }

    @Override
    public int update(User user) {
        //二次加密
        if(user.getPassword()!=null){
            String password = user.getPassword();
            String salt = getUserByID(user.getId()).getSalt();
            user.setPassword( MD5Util.formPassToDBPass(password, salt));
        }

        return userDao.update(user);
    }

    @Override
    public User getUserByID(int id) {
        return userDao.getUserByID(id);
    }

    @Override
    public Integer deleteByID(Integer id) {
        return userDao.deleteByID(id);
    }

    @Override
    public List<User> getUsersByPage(Page page) {
        // 当前页开始index
        int startIndex = page.getPageSize()*(page.getCurrentPage()-1);
        return userDao.getUsersByPage(startIndex, page.getPageSize());
    }

    public User getUserByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("display_name", username);
        return userDao.selectOne(queryWrapper);
    }

    public UserDto getUserDto(User user) {
        return new UserDto(user.getId(), user.getDisplayName(), user.getGender(), user.getIdNum(), user.getMobile(), user.getHome());
    }
}




