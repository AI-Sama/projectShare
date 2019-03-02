package com.projectShare.mapper;


import com.projectShare.Pojo.Items;
import com.projectShare.Pojo.ItemsDevelop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//自动生成的分类mapper
public interface ItemsMapper{
    public void insertItem(Items items);//插入项目
    public List<ItemsDevelop> selectItems(@Param(value ="assortmentId" )Integer assortmentId,@Param(value ="star" ) Integer star);//根据分类查找已审核项目
    public Integer selectCountItem();//查找项目总数量
    public  void deleteItems(@Param(value = "id") Integer id);//删除项目
    public void changeItem(Items items);//修改项目
    public List<ItemsDevelop> selectAllAuditingItems();//查找所有待审核的项目
    //审核.传入一个审核结果,1是通过,2是未通过
    public void changeItemState(@Param(value = "itemState") Integer itemState,@Param(value = "id") Integer id);
    public List<ItemsDevelop> selectItemsForUser(@Param(value ="userId") Integer userId,@Param(value ="star" ) Integer star);//根据userid查找项目
}