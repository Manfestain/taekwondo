package com.certificate.Taekwondo;

import com.certificate.Taekwondo.service.CertificateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class updateCertificateTests {

    @Autowired
    private CertificateService certificateService;

    @Test
    public void updateCertificate() {
        int id = 1;
//        String updateFields = "rank";
        Object updateValues = "张震";
        String updateFields = "name";
        certificateService.updateCertificate(updateFields, updateValues, id);
    }
}
