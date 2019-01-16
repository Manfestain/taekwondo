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

}
