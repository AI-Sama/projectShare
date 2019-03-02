package com.projectShare.mapper;


import com.projectShare.Pojo.Assortment;

import java.util.List;

//自动生成的分类mapper
public interface AssortmentMapper {
    public void insertAssortment(Assortment assortment);//增加一个分类

    public void changeAssortment(Assortment assortment);//修改一个分类

    public void deleteAssortment(Assortment assortment);//删除一个分类

    public List<Assortment> selectAssortment();//查找全部分类
}