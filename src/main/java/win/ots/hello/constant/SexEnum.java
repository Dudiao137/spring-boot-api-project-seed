package win.ots.hello.constant;

/**
 * @author : sy.wang
 * @date : 20191015
 */
public enum SexEnum {

    MALE(0),
    FEMALE(1);

    private int id;

    SexEnum(int id) {
        this.id = id;
    }

    public static SexEnum getById(int id) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (id == sexEnum.id) {
                return sexEnum;
            }
        }
        return MALE;
    }
}
