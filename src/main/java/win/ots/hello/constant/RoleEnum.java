package win.ots.hello.constant;

/**
 * @author : sy.wang
 * @date : 20191015
 */
public enum RoleEnum {
    root(1L, "超级管理员"),
    admin(2L, "系统管理员"),
    user(3L, "一般用户");

    private Long id;

    private String roleName;

    RoleEnum(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
