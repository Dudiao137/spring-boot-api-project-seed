package win.ots.hello.web.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: sy.wang
 * @date: 20190929
 */
@Data
public class UserCreateVo {

	@ApiModelProperty("用户名")
	@NotBlank
	private String userName;

	@ApiModelProperty("登录密码")
	@NotBlank
	private String password;

	@ApiModelProperty("用户昵称")
	@NotBlank
	private String nickName;

	@ApiModelProperty("手机号")
	private String phone;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("头像")
	private String avatar;

	@ApiModelProperty("性别 0 男 1 女")
	private Integer sex = 0;

}
