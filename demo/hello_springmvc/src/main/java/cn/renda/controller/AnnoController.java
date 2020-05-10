package cn.renda.controller;

import cn.renda.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author Renda Zhang
 * @create 2020-05-01 16:32
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "msg") //把msg存到sessionScope中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username") String name) {
        System.out.println("testRequestParam执行了。。。");
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody执行了。。。");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("testPathVariable执行了。。。");
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testRequestHeader执行了。。。");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testCookieValue执行了。。。");
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user );
        return "success";
    }

    @ModelAttribute
    public void showUser(String name, Map<String, User> map) {
        System.out.println("showUser执行了。。。");
        //模拟通过数据库查询
        User user = new User();
        user.setAge(20);
        user.setDate(new Date());
        user.setName("RendaZhang");
        map.put("abc", user);
    }

/*    @ModelAttribute
    public User showUser(String name) {
        System.out.println("showUser执行了。。。");
        //模拟通过数据库查询
        User user = new User();
        user.setAge(20);
        user.setDate(new Date());
        user.setName("RendaZhang");
        return user;
    }*/

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了。。。");

        model.addAttribute("msg", "妹妹");

        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes执行了。。。");

        String msg = (String) modelMap.get("msg");
        System.out.println("getSessionAttributes取值：" + msg);

        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus) {
        System.out.println("delSessionAttributes执行了。。。");

        sessionStatus.setComplete();

        return "success";
    }
}
