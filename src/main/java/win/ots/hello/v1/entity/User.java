package win.ots.hello.v1.entity;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Author sy.wang
 * Date  2019-09-29
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private String nickName;
    private String phone;
    private String email;
    private String avatar;
    private int sex;
    private Timestamp registerDate;


    public User(){
    }

    public void setId (int id) {this.id = id;} 
    public int getId(){ return id;} 
    public void setUsername (String username) {this.username = username;} 
    public String getUsername(){ return username;} 
    public void setPassword (String password) {this.password = password;} 
    public String getPassword(){ return password;} 
    public void setNickName (String nickName) {this.nickName = nickName;} 
    public String getNickName(){ return nickName;} 
    public void setPhone (String phone) {this.phone = phone;} 
    public String getPhone(){ return phone;} 
    public void setEmail (String email) {this.email = email;} 
    public String getEmail(){ return email;} 
    public void setAvatar (String avatar) {this.avatar = avatar;} 
    public String getAvatar(){ return avatar;} 
    public void setSex (int sex) {this.sex = sex;} 
    public int getSex(){ return sex;} 
    public void setRegisterDate (Timestamp registerDate) {this.registerDate = registerDate;} 
    public Timestamp getRegisterDate(){ return registerDate;} 

}