package com.cdut.epidemicsystem.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String displayName;

    private String gender;

    private String idNum;

    private String mobile;

    private String home;


}
