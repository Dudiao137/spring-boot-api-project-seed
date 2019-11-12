package win.ots.hello.core.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一API响应结果封装
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    @ApiModelProperty("返回码")
    private int code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回数据")
    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

}
