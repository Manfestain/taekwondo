package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.model.ViewObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.text.View;

@Controller
public class MemberController {

    // 处理查询证书页面请求
    @RequestMapping(value = {"/memberquery/"}, method = {RequestMethod.GET})
    public String showMemberQueryPages(Model model) {
        ViewObject vo = new ViewObject();
        vo.set("dir1", "会员查询");
        vo.set("name1", "会员查询");
        vo.set("name2", "会员查询结果");
        vo.set("action", "#");
        model.addAttribute("vo", vo);
        return "authenticate";
    }

}
