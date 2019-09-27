package win.ots.hello.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultCode;
import win.ots.hello.core.util.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 * @author : sy.wang
 * @date : 20190927
 */
@Slf4j
@Component
public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Result result = new Result();
        if (ex instanceof ServiceException) {                                       //业务失败的异常，如“账号或密码错误”
            result.setCode(ResultCode.FAIL).setMessage(ex.getMessage());
            log.info(ex.getMessage());
        } else if (ex instanceof NoHandlerFoundException) {
            result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
        } else if (ex instanceof ServletException) {
            result.setCode(ResultCode.FAIL).setMessage(ex.getMessage());
        } else {
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
            String message;
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                        request.getRequestURI(),
                        handlerMethod.getBean().getClass().getName(),
                        handlerMethod.getMethod().getName(),
                        ex.getMessage());
            } else {
                message = ex.getMessage();
            }
            log.error(message, ex);
        }
        HttpUtils.responseResult(response, result);
        return new ModelAndView();
    }
}
