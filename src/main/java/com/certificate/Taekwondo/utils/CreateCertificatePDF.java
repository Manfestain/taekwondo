package com.certificate.Taekwondo.utils;

import com.certificate.Taekwondo.model.Certificate;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreateCertificatePDF {
    // 根据pdf模板填充信息，生成证书的pdf
    public Document createCertPDF(OutputStream out) {
        String pdfName = "../images/templatePDF.pdf";
        PdfReader reader = null;
        try {
            reader = new PdfReader(pdfName);
            PdfWriter writer = PdfWriter.getInstance(
                    new Document(PageSize.A4, 50, 50, 60, 60),
                    out);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }

    public static void main(String[] args) {
        CreateCertificatePDF ccp = new CreateCertificatePDF();
        FileOutputStream out = new FileOutputStream();
        ccp.createCertPDF(out);
        System.out.println(out);

        }
    }

}
