package win.ots.hello.core.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Slf4j
public class LogCostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long end = System.currentTimeMillis();

        log.info("Execute {} \t cost {} ms", ((HttpServletRequest)servletRequest).getRequestURI(), end-start);
    }

    @Override
    public void destroy() {

    }
}