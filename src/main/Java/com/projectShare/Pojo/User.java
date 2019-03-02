package com.projectShare.Pojo;

import java.util.Date;

public class User {
    private Integer id;//主键
    private  String stuID;//学号
    private  String name;//姓名
    private  String nickName;//昵称
    private  String password;//密码
    private  String personalSign;//个人签名
    private  Integer userLv;//等级权限
    private  Date registerTime;//注册时间
    private  String headImg;//头像图片
    private String userClass;//班级

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stuID='" + stuID + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", personalSign='" + personalSign + '\'' +
                ", userLv=" + userLv +
                ", registerTime=" + registerTime +
                ", headImg='" + headImg + '\'' +
                ", userClass='" + userClass + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalSign() {
        return personalSign;
    }

    public void setPersonalSign(String personalSign) {
        this.personalSign = personalSign;
    }

    public Integer getUserLv() {
        return userLv;
    }

    public void setUserLv(Integer userLv) {
        this.userLv = userLv;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }
}
