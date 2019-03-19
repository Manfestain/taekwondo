package com.certificate.Taekwondo.service;

import com.certificate.Taekwondo.dao.LoginTicketDAO;
import com.certificate.Taekwondo.dao.UserDAO;
import com.certificate.Taekwondo.model.User;
import com.certificate.Taekwondo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    LoginTicketDAO loginTicketDAO;

    @Autowired
    LoginTicketService loginTicketService;

    // 添加用户
    public void addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        user.setPassword(MD5Util.MD5(password + user.getSalt()));

        userDAO.insertUser(user);

        String ticket = loginTicketService.addUserTicket(user.getId());
    }

    // 根据用户名查询密码并验证
    public Map<String, String> login(String username, String password) {
        Map<String, String> map = new HashMap<String, String>();
        User user = userDAO.selectUserByUsername(username);

        if(user == null) {
            map.put("msg", "用户不存在");
            return map;
        }
        if(StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空");
            return  map;
        }
        if(StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }
        if(!MD5Util.MD5(password + user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确");
            return map;
        }

        String ticket = loginTicketService.addUserTicket(user.getId());
        map.put("ticket", ticket);

        return map;
    }

    public void logout(String ticket) {
        loginTicketDAO.updateStatusCode(ticket, 1);
    }
}
