package com.cdut.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_vistor
 */
@TableName(value ="t_vistor")
@Data
public class Vistor implements Serializable {
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

    /**
     * 体温
     */
    private Double temprature;

    /**
     * 是否佩戴口罩
     */
    private Integer mask;

    /**
     * 是否到过疫区
     */
    private Integer dangerZone;

    /**
     * 健康状态 1.健康 2.发热
     */
    private Integer healthStatus;

    /**
     * 到访事由
     */
    private String reason;

    /**
     * 来源地信息
     */
    private String source;

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
        Vistor other = (Vistor) that;
        return (this.getRequestId() == null ? other.getRequestId() == null : this.getRequestId().equals(other.getRequestId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTemprature() == null ? other.getTemprature() == null : this.getTemprature().equals(other.getTemprature()))
            && (this.getMask() == null ? other.getMask() == null : this.getMask().equals(other.getMask()))
            && (this.getDangerZone() == null ? other.getDangerZone() == null : this.getDangerZone().equals(other.getDangerZone()))
            && (this.getHealthStatus() == null ? other.getHealthStatus() == null : this.getHealthStatus().equals(other.getHealthStatus()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getIdNum() == null ? other.getIdNum() == null : this.getIdNum().equals(other.getIdNum()))
            && (this.getHome() == null ? other.getHome() == null : this.getHome().equals(other.getHome()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRequestId() == null) ? 0 : getRequestId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTemprature() == null) ? 0 : getTemprature().hashCode());
        result = prime * result + ((getMask() == null) ? 0 : getMask().hashCode());
        result = prime * result + ((getDangerZone() == null) ? 0 : getDangerZone().hashCode());
        result = prime * result + ((getHealthStatus() == null) ? 0 : getHealthStatus().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getIdNum() == null) ? 0 : getIdNum().hashCode());
        result = prime * result + ((getHome() == null) ? 0 : getHome().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
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
        sb.append(", reason=").append(reason);
        sb.append(", source=").append(source);
        sb.append(", summary=").append(summary);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}