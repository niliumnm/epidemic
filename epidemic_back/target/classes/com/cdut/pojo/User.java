package com.cdut.pojo;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Getter
@ConfigurationProperties(prefix = "user")
@Component
public class User {
    private int id;
    private String password;
    private String displayName;
    private String email;
    private String mobile;
    private String avatarUrl;
    private String organization;
    private String department;
    private String position;
    private String birthday;
    private String address;
    private String weiXin;
    private String qq;
    private String salt;
}