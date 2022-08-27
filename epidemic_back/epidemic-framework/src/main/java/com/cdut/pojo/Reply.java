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
 * @TableName t_reply
 */
@TableName(value ="t_reply")
@Data
public class Reply implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer repId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String mobile;

    /**
     * 
     */
    private Date time;

    /**
     * 1进2出3外来
     */
    private Integer type;

    /**
     * 1健康2发热
     */
    private Integer healthStatue;

    /**
     * 1佩戴2未佩戴
     */
    private Integer mask;

    /**
     * 备注
     */
    private String summary;

    /**
     * 通过与否
     */
    private Integer passed;

    /**
     * 体温
     */
    private Double temprature;

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
        Reply other = (Reply) that;
        return (this.getRepId() == null ? other.getRepId() == null : this.getRepId().equals(other.getRepId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getHealthStatue() == null ? other.getHealthStatue() == null : this.getHealthStatue().equals(other.getHealthStatue()))
            && (this.getMask() == null ? other.getMask() == null : this.getMask().equals(other.getMask()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getPassed() == null ? other.getPassed() == null : this.getPassed().equals(other.getPassed()))
            && (this.getTemprature() == null ? other.getTemprature() == null : this.getTemprature().equals(other.getTemprature()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRepId() == null) ? 0 : getRepId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getHealthStatue() == null) ? 0 : getHealthStatue().hashCode());
        result = prime * result + ((getMask() == null) ? 0 : getMask().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getPassed() == null) ? 0 : getPassed().hashCode());
        result = prime * result + ((getTemprature() == null) ? 0 : getTemprature().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", repId=").append(repId);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", mobile=").append(mobile);
        sb.append(", time=").append(time);
        sb.append(", type=").append(type);
        sb.append(", healthStatue=").append(healthStatue);
        sb.append(", mask=").append(mask);
        sb.append(", summary=").append(summary);
        sb.append(", passed=").append(passed);
        sb.append(", temprature=").append(temprature);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}