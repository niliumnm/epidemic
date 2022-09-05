package com.cdut.epidemicsystem.mapper;

import com.cdut.epidemicsystem.pojo.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author 47345
* @description 针对表【t_reply】的数据库操作Mapper
* @createDate 2022-08-26 13:04:11
* @Entity com.cdut.pojo.Reply
*/
@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {
    public List<Reply> findByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}




