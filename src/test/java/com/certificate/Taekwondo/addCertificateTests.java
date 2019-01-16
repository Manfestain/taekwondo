package com.certificate.Taekwondo;

import com.certificate.Taekwondo.dao.CertificateDAO;
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
        String number = "SXY1106998";
        String name = "刘英";
        String gender = "女";
        String rank = "六级";
        Date birthday = new Date();
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2000-9-4");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        String exminer = "谭文强";
        Date date = new Date();

        certificateService.addCertificate(name, number, gender, birthday, rank, exminer, date);
    }
}
