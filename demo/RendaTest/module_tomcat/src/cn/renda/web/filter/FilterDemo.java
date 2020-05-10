package cn.renda.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Renda Zhang
 * @create 2020-04-24 22:43
 */
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FilterDemo implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FileterDemo is executed.");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
