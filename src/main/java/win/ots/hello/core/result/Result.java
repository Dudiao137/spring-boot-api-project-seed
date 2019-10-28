package win.ots.hello.core.result;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一API响应结果封装
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

}
