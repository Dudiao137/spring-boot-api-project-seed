package win.ots.hello.web.vo;

import lombok.Data;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@Data
public class RoleUserVo {
    private Integer userId;

    private Integer roleId;

    private String role;

    private String roleName;
}
