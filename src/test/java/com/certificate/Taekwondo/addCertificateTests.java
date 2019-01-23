package com.certificate.Taekwondo;

import com.certificate.Taekwondo.dao.CertificateDAO;
import com.certificate.Taekwondo.model.Certificate;
import com.certificate.Taekwondo.service.CertificateService;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class addCertificateTests {

    @Autowired
    CertificateDAO certificateDAO;

    @Autowired
    private CertificateService certificateService;

    @Test
    public void insertCertificate() {
        String number = "ZXD15481432336309";
//        Certificate certificate = certificateDAO.selectCertificateByNumber(number);
        Certificate certificate = certificateService.selectCertificateByNumber(number);
        System.out.println(certificate.getName());
        System.out.println(certificate.getRank());

    }
}
