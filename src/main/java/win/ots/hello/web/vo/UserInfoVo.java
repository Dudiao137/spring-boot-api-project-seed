package win.ots.hello.web.vo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: sy.wang
 * @date: 20190929
 */
@Data
public class UserInfoVo {

    private Long id;

    private String userName;

	private String nickName;

	private String phone;

	private String email;

	private String avatar;

	private String sexName;

	private java.util.Date registerDate;

	private Set<String> roles = new HashSet<>();

}
