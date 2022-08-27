package com.cdut.mapper;

import com.cdut.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 47345
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-08-26 13:04:12
* @Entity com.cdut.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getAll();

    User findByName(@Param("username")String username);

    int insert(@Param("user") User user);

    User getUserByID(@Param("id")int id);

    int update(@Param("user")User user);

    Integer deleteByID(@Param("id") Integer id);

    List<User> getUsersByPage(@Param("startIndex") int startIndex, @Param("size") int size);


}




