package com.certificate.Taekwondo.service;

import com.certificate.Taekwondo.dao.CertificateDAO;
import com.certificate.Taekwondo.model.Certificate;
import com.certificate.Taekwondo.utils.DateUtil;
import com.certificate.Taekwondo.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CertificateService {
    @Autowired
    private CertificateDAO certificateDAO;

    // 添加单个证书信息
    public Map<String, String> addSingleCertificate(String name,
                                              String number,
                                              String gender,
                                              Date birthday,
                                              String rank,
                                              String examiner,
                                              Date date) {
        Map<String, String> map = new HashMap<String, String>();
        Certificate certificate = new Certificate();
        certificate.setNumber(number);
        certificate.setName(name);
        certificate.setGender(gender);
        certificate.setBirthday(birthday);
        certificate.setRank(rank);
        certificate.setExaminer(examiner);
        certificate.setDate(date);

        certificateDAO.insertCertificate(certificate);
        map.put("msg", "证书信息录入完成");
        return map;
    }

    // 添加多个证书信息
    public Map<String, String> addExcelCertificate(MultipartFile file) {
        Map<String, String> map = new HashMap<String, String>();
        List<List> list = ExcelUtil.readExcel(file);
        Certificate certificate = new Certificate();
        int certNum;
        for(certNum=0; certNum < list.size(); ++certNum) {
            List<String> info = list.get(certNum);
            certificate.setName(info.get(0));
            certificate.setBirthday(DateUtil.stringToDate(info.get(1)));    // 时间-出生日期
            certificate.setExaminer(info.get(2));
            certificate.setDate(DateUtil.stringToDate(info.get(3)));   // 时间-证书时间
            certificate.setGender(info.get(4));
            certificate.setNumber(info.get(5));
            certificate.setRank(info.get(6));
            certificateDAO.insertCertificate(certificate);
        }
        if (certNum == list.size()) {
            map.put("msg", "添加证书信息成功！");
        } else {
            map.put("msg", "添加证书信息失败！");
        }
        return map;
    }

    // 根据证书编号查询证书
    public Map<String, Object> selectCertificateByNumber(String number) {
        Map<String, Object> map = new HashMap<String, Object>();
        Certificate certificate = certificateDAO.selectCertificateByNumber(number);
        if(certificate != null) {
            map.put("certificate", certificate);
            map.put("msg", "success");
        }else {
            map.put("msg", "failed");
        }
        return map;
    }

    // 更新证书信息
    public Map<String, String> updateCertificate(String updateFields,
                                                 Object updateValue,
                                                 int id) {
        List<String> tableFileds = new ArrayList<String>(){{
            add("number");
            add("name");
            add("gender");
            add("rank");
            add("birthday");
            add("examiner");
            add("date");
        }};
        Map<String, String> map = new HashMap<String, String>();

        if(tableFileds.contains(updateFields)) {
            certificateDAO.updateCertificateById(id, updateFields, updateValue);
            map.put("msg", "信息更新成功");
            return map;
        }

        map.put("msg", "信息更新出错");
        return map;
    }

}
