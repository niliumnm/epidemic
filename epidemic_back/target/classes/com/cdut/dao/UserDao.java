package com.cdut.dao;

import com.cdut.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> getAll();

    User findByName(@Param("username")String username);

    int insert(@Param("user") User user);

    User getUserByID(@Param("id")int id);

    int update(@Param("user")User user);

    Integer deleteByID(@Param("id") Integer id);
}
