package win.ots.hello.constant;

/**
 * @author : sy.wang
 * @date : 20191015
 */
public enum RoleEnum {
    root(1, "超级管理员"),
    admin(2, "系统管理员"),
    user(3, "一般用户");

    private Integer id;

    private String roleName;

    RoleEnum(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public static RoleEnum getById(Integer id) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.id == id) {
                return roleEnum;
            }
        }
        return user;
    }
}
