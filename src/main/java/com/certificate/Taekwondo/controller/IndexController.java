package com.certificate.Taekwondo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {

    @RequestMapping(path={"/"}, method = {RequestMethod.GET})
    public String index(Model model){
        String vos = "this is home page";
        model.addAttribute("vos", vos);
        return "index";
    }

    @RequestMapping(path = {"/introduce/"}, method = {RequestMethod.GET})
    public String showIntroducePages(Model model) {
        model.addAttribute("msg", "show introduce page");
        return "introduce";
    }
    @RequestMapping(path = {"/organization/"}, method = {RequestMethod.GET})
    public String showOrganizationPages(Model model) {
        model.addAttribute("msg", "show introduce page");
        return "organization";
    }

}
