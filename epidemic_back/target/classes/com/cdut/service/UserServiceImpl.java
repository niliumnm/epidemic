package com.cdut.service;

import com.cdut.dao.UserDao;
import com.cdut.pojo.User;
import com.cdut.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public int register(User user) {
        System.out.println(user.toString());
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        //二次加密
        String password = user.getPassword();
        String salt = getUserByID(user.getId()).getSalt();
        user.setPassword( MD5Util.formPassToDBPass(password, salt));
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

}
