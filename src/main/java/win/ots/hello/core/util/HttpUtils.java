package win.ots.hello.core.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import win.ots.hello.core.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Slf4j
public class HttpUtils {

    public static void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

}
