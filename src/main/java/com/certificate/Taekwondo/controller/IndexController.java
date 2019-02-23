package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@Controller
public class IndexController {
    @Autowired
    private CertificateService certificateService;

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

    @ExceptionHandler
    public String error(Model model,
                        Exception e) {
        return "error";
    }

}
