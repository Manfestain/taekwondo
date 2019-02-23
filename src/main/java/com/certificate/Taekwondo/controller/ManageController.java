package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class ManageController {

    @Autowired
    CertificateService certificateService;

    @RequestMapping(value = {"/admin/news_add/"}, method = {RequestMethod.GET})
    public String newsAdd(Model model) {
        return "adform_upload";
    }
    @RequestMapping(value = {"/admin/news_talbes/"}, method = {RequestMethod.GET})
    public String newsTables(Model model) {
        return "adtables_dynamic";
    }

    @RequestMapping(value = {"/admin/cert_tables/"}, method = {RequestMethod.GET})
    public String certTables(Model model) {
        return "adtables_dynamic";
    }
    @RequestMapping(value = {"/admin/cert_add/"}, method = {RequestMethod.GET})
    public String certAdd(Model model) {
        return "adform_validation";
    }
    @RequestMapping(value = {"/admin/cert_adds/"}, method = {RequestMethod.GET})
    public String certAdds(Model model) {
        return "adform";
    }

    @RequestMapping(value = {"/admin/person_add/"}, method = {RequestMethod.GET})
    public String personAdd(Model model) {
        return "adform_validation";
    }
    @RequestMapping(value = {"/admin/person_gallery/"}, method = {RequestMethod.GET})
    public String personGallery(Model model) {
        return "admedia_gallery";
    }

    @RequestMapping(value = {"/admin/form/"}, method = {RequestMethod.GET})
    public String form(Model model) {
        return "form";
    }


    @RequestMapping(path = {"/admin/file/"}, method = {RequestMethod.GET})
    public String file(Model model) {
        return "uploadfile";
    }

    @RequestMapping(path = {"/admin/upload/"}, method = {RequestMethod.POST})
    public String uploadFile(Model model,
                             @RequestParam("excel_file") MultipartFile excelFile) {
        Map<String, String> map = certificateService.addExcelCertificate(excelFile);
        model.addAttribute("map", map);
        return "about";
    }

    @RequestMapping(path = {"/admin/home/"}, method = {RequestMethod.GET})
    public String adminPage(Model model) {
        return "adhome";
    }
}
