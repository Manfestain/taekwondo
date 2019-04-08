package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.model.ViewObject;
import com.certificate.Taekwondo.utils.GetJsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DanController {

    @RequestMapping(value = {"/danpage/"}, method = {RequestMethod.GET})
    public String danSearchPage(Model model) {
        ViewObject vo = new ViewObject();
        vo.set("dir1", "段位查询");
        vo.set("name1", "段位查询");
        vo.set("name2", "段位查询结果");
        model.addAttribute("vo", vo);
        return "danquery";
    }

    @RequestMapping(value = {"/danSearch/"}, method = {RequestMethod.GET})
    public String SearchDan(Model model,
                            @RequestParam("name") String name,
                            @RequestParam("id_number") String dan_number) {
        Map<String, String> map = GetJsonUtil.getDanJson(name, dan_number);

        ViewObject vo = new ViewObject();
        vo.set("dir1", "段位查询");
        vo.set("name1", "段位查询");
        vo.set("name2", "段位查询结果");
        if(!map.isEmpty() && map.get("have").equals("yes")) {
            vo.set("have", "yes");
            vo.set("img", map.get("0"));
            vo.set("name", map.get("1"));
            vo.set("dan", map.get("3"));
            vo.set("number", map.get("4"));
            vo.set("date", map.get("5"));
        }
        model.addAttribute(vo);
        return "danquery";
    }

}
