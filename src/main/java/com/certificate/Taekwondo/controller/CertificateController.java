package com.certificate.Taekwondo.controller;

import com.certificate.Taekwondo.model.Certificate;
import com.certificate.Taekwondo.model.ViewObject;
import com.certificate.Taekwondo.service.CertificateService;
import com.certificate.Taekwondo.utils.ImageUtil;
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
import java.nio.file.Files;
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
        ViewObject vo = new ViewObject();
        vo.set("dir1", "级位查询");
        vo.set("name1", "级位查询");
        vo.set("name2", "级位查询结果");
        vo.set("action", "getcertimg()");
        model.addAttribute("vo", vo);
        return "authenticate";
    }

    // 处理二维码请求
    @RequestMapping(value = {"/cert/{certnumber}"}, method = {RequestMethod.GET})
    public String showQRcodeResult(Model model,
                                   @PathVariable("certnumber") String number) {
        model.addAttribute("certId", number);
        return "qrcertshow";
    }

    // 处理查询证书请求
    @RequestMapping(value = {"/cert/show/{certnumber}"}, method = {RequestMethod.GET})
    @ResponseBody
    public void showCertQueryResult(@PathVariable("certnumber") String number,
                                    HttpServletResponse response) {
        Certificate certificate = certificateService.selectCertificateByNumber(number);
        byte[] bytes = null;
        if(certificate == null) {
            bytes = ImageUtil.incorrectImg();
        } else {
            bytes = ImageUtil.pressText(certificate);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            response.getOutputStream().write(bytes);
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
