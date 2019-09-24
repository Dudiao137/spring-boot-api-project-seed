package com.company.project.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @Column(name = "nick_name")
    private String nickName;

    private String phone;

    private String email;

    private String avatar;

    private Integer sex;

    @Column(name = "register_date")
    private Date registerDate;

}