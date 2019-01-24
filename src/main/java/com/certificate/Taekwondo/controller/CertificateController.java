package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.model.Certificate;
import com.certificate.Taekwondo.service.CertificateService;
import com.certificate.Taekwondo.utils.PDFUtil;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // 处理查询证书页面请求
    @RequestMapping(value = {"/certquery/"}, method = {RequestMethod.GET})
    public String showCertQueryPages(Model model) {
        model.addAttribute("msg", "this is certQuery");
        return "authenticate";
    }

    // 处理查询证书请求
    @RequestMapping(value = {"/certshow"}, method = {RequestMethod.POST})
    public String showCertQueryResult(Model model,
                                      @RequestParam("certId") String certId) {
//        Map<String, Object> map = certificateService.selectCertificateByNumber(certId);
//        if(map.get("msg").equals("success")) {
//            model.addAttribute("certificate", map.get("certificate"));
//        }else {
//            model.addAttribute("msg", "无查询结果，请核对证书编号重新查询！");
//        }
        return "";
    }

    // 处理二维码请求
    @RequestMapping(value = {"/cert/{certnumber}"}, method = {RequestMethod.GET})
    public String showQRcodeResult(Model model,
                                   @PathVariable("certnumber") String number) {
        model.addAttribute("certId", number);
        return "qrcertshow";
    }
    @RequestMapping(value = {"/showPdf/{certId}"}, method = {RequestMethod.GET})
    @ResponseBody
    public void getPdfStream(@PathVariable("certId") String number,
                             HttpServletResponse response) {
        Certificate certificate = certificateService.selectCertificateByNumber(number);
        byte[] bytes= PDFUtil.createCertPDF(certificate, number);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            response.getOutputStream().write(bufferedImage);
        } catch (Exception e) {
            e.getMessage();
        }
        response.setContentType("image/png");
        try {
            OutputStream stream = response.getOutputStream();
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
