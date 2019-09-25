package win.ots.hello.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	@Column(name = "nick_name")
	private String nickName;

	private String phone;

	private String email;

	private String avatar;

	private Long sex;

	@Column(name = "register_date")
	private java.util.Date registerDate;

}
