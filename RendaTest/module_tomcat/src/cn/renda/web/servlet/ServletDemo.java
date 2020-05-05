package cn.renda.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Renda Zhang
 * @create 2020-04-23 0:09
 */
@WebServlet("/demo")
public class ServletDemo implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
