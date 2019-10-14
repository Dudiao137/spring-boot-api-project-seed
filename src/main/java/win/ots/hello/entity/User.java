package win.ots.hello.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /* column = id */
    private int id;

    /* column = user_name */
    private String userName;

    /* column = password */
    private String password;

    /* column = salt */
    private String salt;

    /* column = nick_name */
    private String nickName;

    /* column = phone */
    private String phone;

    /* column = email */
    private String email;

    /* column = avatar */
    private String avatar;

    /* column = sex */
    private Integer sex;

    /* column = register_date */
    private Date registerDate;


}