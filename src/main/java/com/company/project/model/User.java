package com.company.project.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_user")
public class User {

    private Integer id;

    private String username;

    private String password;

    private String nickName;

    private String phone;

    private String email;

    private String avatar;

    private Integer sex;

    private Date registerDate;

}