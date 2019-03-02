package com.projectShare.Pojo;

import java.util.Date;

public class Assortment {
    private  Integer id;//分类id(主键)
    private  String  fName;//分类名称
    private   Date   createTime;//创建时间
    private   Date  modifyTime;//修改时间

    @Override
    public String toString() {
        return "Assortment{" +
                "id=" + id +
                ", Fname='" + fName + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
