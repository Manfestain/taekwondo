package com.certificate.Taekwondo.service;

import com.certificate.Taekwondo.dao.MasterDAO;
import com.certificate.Taekwondo.model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MasterService {

    @Autowired
    private MasterDAO masterDAO;

    // 添加成员信息
    public Map<String, String> addMaster(String name,
                                         String gender,
                                         int age,
                                         String photoUrl,
                                         String office,
                                         String introduce) {
        Map<String, String> map = new HashMap<String, String>();
        Master master = new Master();
        master.setName(name);
        master.setGender(gender);
        master.setAge(age);
        master.setPhotoUrl(photoUrl);
        master.setOffice(office);
        master.setIntroduce(introduce);
        masterDAO.insertMaster(master);

        map.put("msg", "成员信息添加成功！");
        return map;
    }

    // 修改成员信息
    public Map<String, String> updateMaster(String updateFields,
                                            Object updateValue,
                                            int id) {
        List<String> tableFileds = new ArrayList<String>(){{
            add("name");
            add("gender");
            add("age");
            add("photo_url");
            add("office");
            add("introduce");
        }};
        Map<String, String> map = new HashMap<String, String>();

        if(tableFileds.contains(updateFields)) {
            masterDAO.updateMasterById(id, updateFields, updateValue);
            map.put("msg", "信息更新成功");
            return map;
        }

        map.put("msg", "信息更新出错");
        return map;
    }
}
