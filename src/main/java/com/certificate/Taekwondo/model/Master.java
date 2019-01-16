package com.certificate.Taekwondo.model;

// 机构成员
public class Master {
    private int id;
    private String photoUrl;   //头像的url
    private String name;
    private String gender;
    private int age;
    private String office;   //所担任职务以及头衔
    private String introduce;   //个人简介，300字以内

    public void setId(int id) {
        this.id = id;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getOffice() {
        return office;
    }

    public String getIntroduce() {
        return introduce;
    }

}
