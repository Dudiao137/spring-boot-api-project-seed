package win.ots.hello.constant;

/**
 * @author: sy.wang
 * @date: 20190929
 */
public enum ErrorMessage {

    CREATE_WITH_NO_INFO("Please add user info to create user!"),
    USER_NAME_EXIST("user name exist, please try annother");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
