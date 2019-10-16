package win.ots.hello.web.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@Data
public class UserRoleRelationInputVo {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer roleId;

}
