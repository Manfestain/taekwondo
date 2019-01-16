package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.model.Certificate;
import com.certificate.Taekwondo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // 处理查询证书页面请求
    @RequestMapping(value = {"/certquery"}, method = {RequestMethod.GET})
    public String showCertQueryPages(Model model) {
        model.addAttribute("msg", "");
        return "";
    }

    // 处理查询证书请求
    @RequestMapping(value = {"/certshow"}, method = {RequestMethod.POST})
    public String showCertQueryResult(Model model,
                                      @RequestParam("certId") String certId) {
        Map<String, Object> map = certificateService.selectCertificateByNumber(certId);
        if(map.get("msg").equals("success")) {
            model.addAttribute("certificate", map.get("certificate"));
        }else {
            model.addAttribute("msg", "无查询结果，请核对证书编号重新查询！");
        }
        return "";
    }

}
