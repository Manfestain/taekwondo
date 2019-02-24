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
                                              String institution,
                                              Date birthday,
                                              String rank,
                                              String examiner,
                                              Date date) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Certificate certificate = new Certificate();
            Certificate cert = certificateDAO.selectCertificateByNumber(number);
            if(cert != null) {
                map.put("msg", "error");
                System.out.println("添加单个这个念书有错，证书编号存在");
                return map;
            }
            certificate.setNumber(number);
            certificate.setName(name);
            certificate.setInstitution(institution);
            certificate.setBirthday(birthday);
            certificate.setGrade(rank);
            certificate.setExaminer(examiner);
            certificate.setDate(date);
            System.out.println("有没有继续执行");

            certificateDAO.insertCertificate(certificate);
            map.put("msg", "success");
            return map;
        } catch (Exception e) {
            map.put("msg", "error");
            return map;
        }
    }

    // 添加多个证书信息
    public Map<String, String> addExcelCertificate(MultipartFile file) {
        Map<String, String> map = new HashMap<String, String>();
        List<List> list = ExcelUtil.readExcel(file);
        Certificate certificate = new Certificate();
        int certNum;
        try {
            for (certNum = 0; certNum < list.size(); ++certNum) {
                List<String> info = list.get(certNum);

                Certificate cert = certificateDAO.selectCertificateByNumber(info.get(5));
                if(cert != null) {
                    map.put("msg", "error");
                    return map;
                }

                certificate.setName(info.get(0));
                certificate.setBirthday(DateUtil.stringToDate(info.get(1)));    // 时间-出生日期
                certificate.setExaminer(info.get(2));
                certificate.setDate(DateUtil.stringToDate(info.get(3)));   // 时间-证书时间
                certificate.setInstitution(info.get(4));   // 发证机构
                certificate.setNumber(info.get(5));
                certificate.setGrade(info.get(6));
                certificateDAO.insertCertificate(certificate);
            }
            if (certNum == list.size()) {
                map.put("msg", "success");
            } else {
                map.put("msg", "error");
            }
            return map;
        }catch (Exception e) {
            map.put("msg", "error");
            return map;
        }
    }

    // 根据证书编号查询证书
    public Certificate selectCertificateByNumber(String number) {
        Certificate certificate = certificateDAO.selectCertificateByNumber(number);
        return certificate;
    }

    // 根据姓名查询
    public List<Certificate> selectCertificateByName(String name) {
        List<Certificate> certificates = certificateDAO.selectCertificateByName(name);
        return certificates;
    }

    // 更新证书信息（单个字段）
    public Map<String, String> updateCertificateSingle(String updateFields,
                                                 Object updateValue,
                                                 int id) {
        List<String> tableFileds = new ArrayList<String>(){{
            add("number");
            add("name");
            add("gender");
            add("grade");
            add("birthday");
            add("examiner");
            add("date");
        }};
        Map<String, String> map = new HashMap<String, String>();

        if(tableFileds.contains(updateFields)) {
            certificateDAO.updateCertificateSingleById(id, updateFields, updateValue);
            map.put("msg", "success");
            return map;
        }

        map.put("msg", "error");
        return map;
    }

    //更新证书
    public Map<String, String> updateCertificate(String name,
                                                 String number,
                                                 String institution,
                                                 Date birthday,
                                                 String rank,
                                                 String examiner,
                                                 Date date) {

        Map<String, String> map = new HashMap<String, String>();
        try {
            certificateDAO.updateCertificateById(number, name, rank, birthday, examiner, date, institution);
            map.put("msg", "success");
            return map;
        } catch (Exception e) {
            map.put("msg", "error");
            return map;
        }

    }

    // 统计
    public int countCertNumber() {
        int count = certificateDAO.countAllData();
        return count;
    }

}
