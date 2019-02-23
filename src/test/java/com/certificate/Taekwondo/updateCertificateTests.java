package com.certificate.Taekwondo;

import com.certificate.Taekwondo.service.CertificateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class updateCertificateTests {

    @Autowired
    private CertificateService certificateService;

    @Test
    public void updateCertificate() {
//        String number = "WMY15481432339730";
//        String name = "张真好";
//        String institution = "志鹰跆拳道";
//        Date birthday = new Date();
//        String examiner = "张志隆";
//        Date date = new Date();
//        String rank = "五级";
//
//        Map<String, String> map = certificateService.updateCertificate(name, number, institution, birthday, rank, examiner, date);
        int count = certificateService.countCertNumber();
        System.out.println(count);

    }
}
