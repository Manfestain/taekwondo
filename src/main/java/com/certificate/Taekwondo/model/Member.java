package com.certificate.Taekwondo.model;

import java.util.Date;

// 会员
public class Member {
    private int id;
    private String number;   // 会员编号
    private String name;
    private String gender;
    private String phone;   // 会员电话
    private String rank;   // 会员级别
    private int points;   // 会员积分
    private String rights;   // 会员权益
    private Date date;   // 加盟日期

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRights(String rights) {
        this.rights = rights;
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

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getRank() {
        return rank;
    }

    public int getPoints() {
        return points;
    }

    public String getRights() {
        return rights;
    }
}
