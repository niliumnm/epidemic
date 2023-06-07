package com.cdut.epidemicsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdut.epidemic_common.utils.AjaxResult;
import com.cdut.epidemicsystem.mapper.*;
import com.cdut.epidemicsystem.pojo.*;
import com.cdut.epidemicsystem.service.DepartmentService;
import com.cdut.epidemicsystem.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * @author 47345
 * @description 针对表【t_reply】的数据库操作Service实现
 * @createDate 2022-08-26 13:04:11
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
        implements ReplyService {

    @Autowired(required = false)
    private UserMapper userDao;

    @Autowired(required = false)
    private InRequestMapper inRequestMapper;

    @Autowired(required = false)
    private OutRequestMapper outRequestMapper;

    @Autowired(required = false)
    private VistorMapper vistorMapper;

    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private DepartmentService departmentService;



    public User getUserById(Integer userId) {
        return userDao.getUserByID(userId);
    }

    public InRequest getInRequest(Integer requestId) {
        return inRequestMapper.selectById(requestId);
    }

    public OutRequest getOutRequest(Integer requestId) {

        return outRequestMapper.selectById(requestId);
    }

    public Vistor getVisRequest(Integer requestId) {
        return vistorMapper.selectById(requestId);
    }

    public List<Reply> getPage(Integer pageNum, Integer pageSize, String name) {
        pageNum = (pageNum - 1) * pageSize;
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        if (!(name.equals(""))){
            queryWrapper.like("name", name);

        }

        queryWrapper.last("limit "  + pageNum + ", " + pageSize);
        List<Reply> replies = replyMapper.selectList(queryWrapper);
        return replies;
    }

    public List<Reply> getTime(Integer pageNum, Integer pageSize, Date begin, Date end) {
        pageNum = (pageNum - 1) * pageSize;
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("time", begin, end);
        queryWrapper.last("limit " + pageNum + ", " + pageSize);
        return replyMapper.selectList(queryWrapper);
    }

    public List<Reply> getList(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);
        return replyMapper.selectList(queryWrapper);
    }


    @Override
    public AjaxResult postRequest(Integer passed, String summary, Integer type, Integer requestId, Integer sysDepartment) {
        Reply reply = new Reply();
        Integer userId=0;
        reply.setType(type);
        reply.setPassed(passed);
        reply.setSummary(summary);



        //HealthStatue
        Integer heathStatus=0;
        Integer mask = 0;
        Double temprature= 0.1;
        Integer requestID = 0;
        Integer department = 0;
        Date desireTime=new Date();
        // 进门
        if (type == 1) {
            InRequest inRequest = getInRequest(requestId);
            heathStatus= inRequest.getHealthStatus();
            mask = inRequest.getMask();
            temprature = inRequest.getTemprature();
            userId = inRequest.getUserId();
            requestID = inRequest.getRequestId();
            department = inRequest.getDepartment();
            desireTime = inRequest.getEnterTime();
        }
        // 出门
        else if (type==2) {
            OutRequest outRequest = getOutRequest(requestId);
            heathStatus=outRequest.getHealthStatus();
            mask=outRequest.getMask();
            temprature = outRequest.getTemprature();
            userId = outRequest.getUserId();
            requestID = outRequest.getRequestId();
            department=outRequest.getRole();
            desireTime = outRequest.getLeaveTime();
        }
        // 外来
        else if (type==3) {
            Vistor visRequest = getVisRequest(requestId);
            heathStatus= visRequest.getHealthStatus();
            mask = visRequest.getMask();
            temprature = visRequest.getTemprature();
            userId = visRequest.getUserId();
            requestID = visRequest.getRequestId();
            department=visRequest.getRole();
            desireTime = visRequest.getEnterTime();
        }
        // 提交申请的人
        User applicant = getUserById(userId);

        reply.setName(applicant.getDisplayName());
        reply.setMobile(applicant.getMobile());
        reply.setHealthStatue(heathStatus);
        reply.setMask(mask);
        reply.setTemprature(temprature);
        reply.setUserId(userId);
        reply.setRequestId(requestID);
        reply.setDesireTime(desireTime);
        if (!department.equals(sysDepartment) && department!=99){
            boolean hasAuthority = hasAuthority(department, sysDepartment);
            if (!hasAuthority){
                return AjaxResult.success("您所在的部门没有权限处理，请联系对应部门获取授权");
            }
        }
        save(reply);
        return AjaxResult.success("回复成功", applicant);
    }

    public boolean hasAuthority(Integer role1, Integer role2) {
        int vice_department=-1;
        Integer masterDepartment1 = departmentService.getDepartmentByID(role1).getMasterDepartment();
        Integer masterDepartment2 = departmentService.getDepartmentByID(role2).getMasterDepartment();
        if (masterDepartment1.equals(masterDepartment2)) {
            return true;
        }
        return false;
    }
}




