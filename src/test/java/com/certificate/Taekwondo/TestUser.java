package com.certificate.Taekwondo;

import com.certificate.Taekwondo.dao.UserDAO;
import com.certificate.Taekwondo.model.User;
import com.certificate.Taekwondo.service.UserService;
import com.certificate.Taekwondo.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        String username = "ninedan";
        String password = "jiuduanlianmeng";
        userService.addUser(username, password);
    }

}
