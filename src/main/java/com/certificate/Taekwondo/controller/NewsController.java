package com.certificate.Taekwondo.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewsController {

    @RequestMapping(value = {"/newsdir/"}, method = {RequestMethod.GET})
    public String showNewsdir(Model model) {
        model.addAttribute("msg", "newsdir pages");
        return "newsdir";
    }

    @RequestMapping(value = {"/firstnews/"}, method = {RequestMethod.GET})
    public String showFirstNews(Model model) {
        return "newsdetail";
    }

}
