package win.ots.hello.web.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: sy.wang
 * @date: 20190926
 */
@Data
public class UserQuery {

    @ApiModelProperty("用户id")
    Long userId;

    @ApiModelProperty("用户名")
    String userName;

}
