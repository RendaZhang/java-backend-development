package cn.renda.controller;

import cn.renda.domain.Account;
import cn.renda.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Renda Zhang
 * @create 2020-05-01 15:03
 */
@Controller
@RequestMapping("/params")
public class ParamsController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("testParam执行了。。。");
        System.out.println("用户名： " + username);
        System.out.println("密码： " + password);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("saveAccount执行了。。。 " + account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("saveUser执行了。。。 " + user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServlet执行了。。。 ");

        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);

        return "success";
    }
}
