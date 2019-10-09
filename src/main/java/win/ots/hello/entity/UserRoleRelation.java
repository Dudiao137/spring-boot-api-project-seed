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
public class UserRoleRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    /* column = id */
    private int id;

    /* column = user_id */
    private int userId;

    /* column = role_id */
    private int roleId;


}