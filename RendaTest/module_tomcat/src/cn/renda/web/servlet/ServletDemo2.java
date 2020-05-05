package cn.renda.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Renda Zhang
 * @create 2020-04-23 12:47
 */
@WebServlet({"/demo2", "/fuck1", "/fuck2"})
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //super.doPost(req, resp);
        System.out.println("ServeleteDemo2...");

        req.setAttribute("key", "值");
        req.getRequestDispatcher("/Hello.jsp").forward(req, resp);
    }
}
