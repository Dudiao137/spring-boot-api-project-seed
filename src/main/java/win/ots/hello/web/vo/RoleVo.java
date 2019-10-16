package win.ots.hello.web.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@Data
public class RoleVo {

    @NotBlank
    private String role;
    @NotBlank
    private String roleName;
}
