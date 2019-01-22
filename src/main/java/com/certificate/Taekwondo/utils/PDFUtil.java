package com.certificate.Taekwondo.utils;

import com.certificate.Taekwondo.model.Certificate;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;

public class PDFUtil {
    static String fontPath = "D:/WorkSpace/JavaCode/Taekwondo/src/main/java/com/certificate/Taekwondo/utils/font/simsun.ttc,1";
    static String templateName = "D:\\WorkSpace\\JavaCode\\Taekwondo\\src\\main\\resources\\images\\demo.pdf";
    public static final String NAME = "STSong-Light";
    public static final String ENCODE = "UniGB-UCS2-H";
    public static final int SIZE = 12;

    // 根据pdf模板填充信息，生成证书的pdf
    public static FileOutputStream createCertPDF(Certificate certificate, FileOutputStream fileOutputStream) {
        PdfReader reader = null;
        PdfStamper stamper = null;
        PdfContentByte pdfContentByte = null;

        try {
            InputStream inputStream = new FileInputStream(new File(templateName));
            reader = new PdfReader(inputStream);
            // fileOutputStream = new FileOutputStream("D:/demo.pdf");
            stamper = new PdfStamper(reader, fileOutputStream);

            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont);
            BaseColor baseColor = new BaseColor(0, 0, 0);
            pdfContentByte = stamper.getOverContent(1);
            pdfContentByte.beginText();
            pdfContentByte.setFontAndSize(font.getBaseFont(), 12);
            pdfContentByte.setColorFill(baseColor);

            pdfContentByte.setTextMatrix(100, 100);   // 级位
            pdfContentByte.showText(certificate.getRank());
            pdfContentByte.setTextMatrix(100, 100);   // 姓名
            pdfContentByte.showText(certificate.getName());
            pdfContentByte.setTextMatrix(100, 100);   // 性别
            pdfContentByte.showText(certificate.getGender());
            pdfContentByte.setTextMatrix(100, 100);   // 生日
            pdfContentByte.showText(certificate.getBirthday().toString());
            pdfContentByte.setTextMatrix(100, 100);   // 监考官
            pdfContentByte.showText(certificate.getExaminer());
            pdfContentByte.setTextMatrix(100, 100);   // 日期
            pdfContentByte.showText(certificate.getDate().toString());

            pdfContentByte.endText();

        } catch (Exception e) {
            // 输出日志
            e.printStackTrace();
        } finally {
            try {
                stamper.close();
                reader.close();
                fileOutputStream.close();
            } catch (Exception _e) {
                _e.printStackTrace();
            }
        }
        return fileOutputStream;
    }
}

