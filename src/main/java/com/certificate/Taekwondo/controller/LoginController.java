package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(path={"/adminlogin/"}, method = {RequestMethod.GET})
    public String adminLogin(Model model){
        return "login";
    }

    @RequestMapping(path={"/login/"}, method = {RequestMethod.POST})
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) {
        try {
            Map<String, String> map = userService.login(username, password);
            if(map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket"));
                cookie.setPath("/");
                response.addCookie(cookie);
                model.addAttribute("ticket", map.get("ticket"));
                return "uploadfile";
            } else {
                model.addAttribute("msg", map.get("msg"));
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "login";
        }

    }
}
