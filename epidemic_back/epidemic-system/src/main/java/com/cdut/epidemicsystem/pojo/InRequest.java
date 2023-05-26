package com.cdut.epidemicsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_in_request
 */
@TableName(value ="t_in_request")
@Data
public class InRequest implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer requestId;

    /**
     * 用户名
     */
    private Integer userId;

    private String name;
    private String gender;
    private String mobile;
    private String idNum;
    private String home;
    private Integer role;

    /**
     * 体温
     */
    private Double temprature;

    /**
     * 是否佩戴口罩 1 戴了 2 未戴
     */
    private Integer mask;

    /**
     * 是否到过疫区 1. 到过 2. 未到过 应该是Bool 生成器转成int了 凑合用
     */
    private Integer dangerZone;

    /**
     * 健康状态 1.健康 2.发热
     */
    private Integer healthStatus;

    /**
     * 备注
     */
    private String summary;

    /**
     * 
     */
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InRequest other = (InRequest) that;
        return (this.getRequestId() == null ? other.getRequestId() == null : this.getRequestId().equals(other.getRequestId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getIdNum() == null ? other.getIdNum() == null : this.getIdNum().equals(other.getIdNum()))
            && (this.getHome() == null ? other.getHome() == null : this.getHome().equals(other.getHome()))
            && (this.getTemprature() == null ? other.getTemprature() == null : this.getTemprature().equals(other.getTemprature()))
            && (this.getMask() == null ? other.getMask() == null : this.getMask().equals(other.getMask()))
            && (this.getDangerZone() == null ? other.getDangerZone() == null : this.getDangerZone().equals(other.getDangerZone()))
            && (this.getHealthStatus() == null ? other.getHealthStatus() == null : this.getHealthStatus().equals(other.getHealthStatus()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRequestId() == null) ? 0 : getRequestId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getIdNum() == null) ? 0 : getIdNum().hashCode());
        result = prime * result + ((getHome() == null) ? 0 : getHome().hashCode());
        result = prime * result + ((getTemprature() == null) ? 0 : getTemprature().hashCode());
        result = prime * result + ((getMask() == null) ? 0 : getMask().hashCode());
        result = prime * result + ((getDangerZone() == null) ? 0 : getDangerZone().hashCode());
        result = prime * result + ((getHealthStatus() == null) ? 0 : getHealthStatus().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requestId=").append(requestId);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", mobile=").append(mobile);
        sb.append(", idNum=").append(idNum);
        sb.append(", home=").append(home);
        sb.append(", temprature=").append(temprature);
        sb.append(", mask=").append(mask);
        sb.append(", dangerZone=").append(dangerZone);
        sb.append(", healthStatus=").append(healthStatus);
        sb.append(", summary=").append(summary);
        sb.append(", time=").append(time);
        sb.append(", role=").append(role);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}