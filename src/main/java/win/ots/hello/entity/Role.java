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
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /* column = id */
    private int id;

    /* column = role */
    private String role;

    /* column = role_name */
    private String roleName;


}