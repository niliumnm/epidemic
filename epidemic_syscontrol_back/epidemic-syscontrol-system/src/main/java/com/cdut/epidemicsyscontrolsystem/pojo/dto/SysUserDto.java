package com.cdut.epidemicsyscontrolsystem.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysUserDto {
    private Integer id;

    private String username;

    private String Address;

    private String IdCardNum;

    private String phone;

    private String realname;

}
