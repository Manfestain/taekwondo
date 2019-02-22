package com.certificate.Taekwondo.model;

import java.util.Date;

// 证书
public class Certificate {
    private int id;
    private String number;   // 证书编号，字母+数字
    private String name;
    private String institution;   // 发证道馆
    private String grade;   // 级位
    private Date birthday;
    private String examiner;   // 监考官
    private Date date;   // 签证日期

    public String getExaminer() {
        return examiner;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getInstitution() {
        return institution;
    }

    public String getGrade() {
        return grade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
