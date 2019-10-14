package win.ots.hello.core.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import win.ots.hello.core.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Slf4j
@Component
public class HttpUtils {

    @Autowired
    private static Gson gson;

    public static void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            String json = gson.toJson(result);
            response.getWriter().write(json);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

}
