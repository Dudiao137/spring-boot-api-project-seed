package win.ots.hello.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: sy.wang
 * @date: 20190929
 */
@Data
public class UserInfoVo {

	@ApiModelProperty("用户id")
    private Long id;

	@ApiModelProperty("用户名")
    private String userName;

	@ApiModelProperty("用户昵称")
	private String nickName;

	@ApiModelProperty("手机号")
	private String phone;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("头像")
	private String avatar;

	@ApiModelProperty("性别")
	private String sexName;

	@ApiModelProperty("注册日期")
	private java.util.Date registerDate;

	@ApiModelProperty("角色列表")
	private Set<String> roles = new HashSet<>();

}
