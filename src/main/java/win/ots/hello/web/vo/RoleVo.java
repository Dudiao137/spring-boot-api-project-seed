package win.ots.hello.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@Data
public class RoleVo {

    @ApiModelProperty("角色标识")
    @NotBlank
    private String role;

    @ApiModelProperty("角色名称")
    @NotBlank
    private String roleName;
}
