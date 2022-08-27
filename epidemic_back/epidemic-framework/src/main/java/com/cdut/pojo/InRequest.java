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
            && (this.getTemprature() == null ? other.getTemprature() == null : this.getTemprature().equals(other.getTemprature()))
            && (this.getMask() == null ? other.getMask() == null : this.getMask().equals(other.getMask()))
            && (this.getDangerZone() == null ? other.getDangerZone() == null : this.getDangerZone().equals(other.getDangerZone()))
            && (this.getHealthStatus() == null ? other.getHealthStatus() == null : this.getHealthStatus().equals(other.getHealthStatus()))
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
        sb.append(", temprature=").append(temprature);
        sb.append(", mask=").append(mask);
        sb.append(", dangerZone=").append(dangerZone);
        sb.append(", healthStatus=").append(healthStatus);
        sb.append(", summary=").append(summary);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}