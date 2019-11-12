package win.ots.hello.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@Data
public class UserRoleRelationInputVo {

    @ApiModelProperty("用户id")
    @NotNull
    private Integer userId;

    @ApiModelProperty("角色id")
    @NotNull
    private Integer roleId;

}
