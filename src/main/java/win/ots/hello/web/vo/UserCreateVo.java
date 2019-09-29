package win.ots.hello.web.vo;

import lombok.Data;

/**
 * @author: sy.wang
 * @date: 20190929
 */
@Data
public class UserCreateVo {

	private String userName;

	private String password;

	private String nickName;

	private String phone;

	private String email;

	private String avatar;

	private Integer sex;

}
