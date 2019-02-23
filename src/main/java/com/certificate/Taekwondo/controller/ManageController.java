package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
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



    @RequestMapping(path = {"/admin/home/"}, method = {RequestMethod.GET})
    public String adminPage(Model model) {
        int count = certificateService.countCertNumber();
        model.addAttribute("total", String.valueOf(count));
        return "adhome";
    }


    // 添加证书
    @RequestMapping(value = {"/admin/addcert/"}, method = {RequestMethod.POST})
    public String addCert(Model model,
                          @RequestParam("number") String number,
                          @RequestParam("name") String name,
                          @RequestParam("institution") String institution,
                          @RequestParam("grade") String grade,
                          @RequestParam("birthday") String birthday,
                          @RequestParam("examiner") String examiner,
                          @RequestParam("date") String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateb = null;
        Date dated = null;
        try{
            dateb = format.parse(birthday);
            dated = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> map = certificateService.addSingleCertificate(name, number, institution, dateb, grade, examiner, dated);
        if(map.get("msg").equals("证书信息录入完成")) {
            model.addAttribute("msg", map.get("msg"));
        } else {
            model.addAttribute("msg", "证书添加失败！");
        }
        return "adform_validation";
    }

    @RequestMapping(path = {"/admin/upload/"}, method = {RequestMethod.POST})
    public String uploadFile(Model model,
                             @RequestParam("excel_file") MultipartFile excelFile) {
        Map<String, String> map = certificateService.addExcelCertificate(excelFile);
        model.addAttribute("msg", map.get("msg"));
        return "adform";
    }

    // 证书修改
    @RequestMapping(value = {"/admin/updatecert/"}, method = {RequestMethod.POST})
    public String updateCert(Model model,
                             @RequestParam("number") String number,
                             @RequestParam("name") String name,
                             @RequestParam("institution") String institution,
                             @RequestParam("grade") String grade,
                             @RequestParam("birthday") String birthday,
                             @RequestParam("examiner") String examiner,
                             @RequestParam("date") String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateb = null;
        Date dated = null;
        try{
            dateb = format.parse(birthday);
            dated = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> map = certificateService.updateCertificate(name, number, institution, dateb, grade, examiner, dated);
        if(map.get("msg").equals("信息更新成功")) {
            model.addAttribute("msg", map.get("msg"));
        } else {
            model.addAttribute("msg", "证书更新失败！");
        }
        return "adform_validation";
    }

//    @RequestMapping(value ={""}, method = {RequestMethod.GET})
//    public String showNameCerts(Model model) {
//        re
//    }
//    @RequestMapping(value ={""}, method = {RequestMethod.GET})
//    public String showNumberCerts(Model model) {
//
//    }
}
