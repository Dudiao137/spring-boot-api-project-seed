package win.ots.hello.web.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: sy.wang
 * @date: 20190929
 */
@Data
public class UserCreateVo {

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

	@NotBlank
	private String nickName;

	private String phone;

	private String email;

	private String avatar;

	private Integer sex = 0;

}
