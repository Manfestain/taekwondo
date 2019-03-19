package com.certificate.Taekwondo.utils;

import com.certificate.Taekwondo.model.Certificate;
import com.certificate.Taekwondo.service.CertificateService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import java.util.Date;

public class PDFUtil {
    static String fontPath = "";
    static String templateName = "";
    public static final String NAME = "STSong-Light";
    public static final String ENCODE = "UniGB-UCS2-H";
    public static final int SIZE = 12;

    // 根据pdf模板填充信息，生成证书的pdf
    public static byte[] createCertPDF(Certificate certificate, String number) {
        System.out.println(number);
        PdfReader reader = null;
        PdfStamper stamper = null;
        PdfContentByte pdfContentByte = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        //FileOutputStream fileOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = new FileInputStream(new File(templateName));
            reader = new PdfReader(inputStream);
            //fileOutputStream = new FileOutputStream("D:/demo.pdf");
            stamper = new PdfStamper(reader, byteArrayOutputStream);

            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont);
            BaseColor baseColor = new BaseColor(0, 0, 0);
            pdfContentByte = stamper.getOverContent(1);
            pdfContentByte.beginText();
            pdfContentByte.setFontAndSize(font.getBaseFont(), 12);
            pdfContentByte.setColorFill(baseColor);

            pdfContentByte.setTextMatrix(100, 100);   // 级位
            pdfContentByte.showText(certificate.getGrade());
            pdfContentByte.setTextMatrix(100, 200);   // 姓名
            pdfContentByte.showText(certificate.getName());
            pdfContentByte.setTextMatrix(100, 300);   // 性别
            pdfContentByte.showText(certificate.getInstitution());
            pdfContentByte.setTextMatrix(100, 400);   // 生日
            pdfContentByte.showText(certificate.getBirthday().toString());
            pdfContentByte.setTextMatrix(100, 500);   // 监考官
            pdfContentByte.showText(certificate.getExaminer());
            pdfContentByte.setTextMatrix(100, 600);   // 日期
            pdfContentByte.showText(certificate.getDate().toString());

            pdfContentByte.endText();

        } catch (Exception e) {
            // 输出日志
            e.printStackTrace();
        } finally {
            try {
                stamper.close();
                reader.close();
                byteArrayOutputStream.close();
            } catch (Exception _e) {
                _e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }


    public static void main(String[] args) {
        Certificate certificate = new Certificate();
        certificate.setName("汪涵与");
        certificate.setInstitution("易道天下武道教育");
        certificate.setNumber("WHY120988943623");
        certificate.setGrade("六级");
        certificate.setBirthday(new Date());
        certificate.setDate(new Date());
        certificate.setExaminer("谭文强");

        byte[] bytes = createCertPDF(certificate, "asdhf");

    }
}

