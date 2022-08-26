package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
public class TUser implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String displayName;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String mobile;

    /**
     * 
     */
    private String avatarUrl;

    /**
     * 
     */
    private String organization;

    /**
     * 
     */
    private String department;

    /**
     * 
     */
    private String position;

    /**
     * 
     */
    private String birthday;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String weixin;

    /**
     * 
     */
    private String qq;

    /**
     * 
     */
    private String salt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * 
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * 
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 
     */
    public String getPosition() {
        return position;
    }

    /**
     * 
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * 
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * 
     */
    public String getQq() {
        return qq;
    }

    /**
     * 
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

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
        TUser other = (TUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getDisplayName() == null ? other.getDisplayName() == null : this.getDisplayName().equals(other.getDisplayName()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null : this.getAvatarUrl().equals(other.getAvatarUrl()))
            && (this.getOrganization() == null ? other.getOrganization() == null : this.getOrganization().equals(other.getOrganization()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getDisplayName() == null) ? 0 : getDisplayName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
        result = prime * result + ((getOrganization() == null) ? 0 : getOrganization().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", password=").append(password);
        sb.append(", displayName=").append(displayName);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", organization=").append(organization);
        sb.append(", department=").append(department);
        sb.append(", position=").append(position);
        sb.append(", birthday=").append(birthday);
        sb.append(", address=").append(address);
        sb.append(", weixin=").append(weixin);
        sb.append(", qq=").append(qq);
        sb.append(", salt=").append(salt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}