package com.projectShare.Pojo;


import java.util.Date;

public class Items {
   private  Integer id;//项目id (主键)
   private  String Iname;//项目标题
   private  String Itext;//项目内容
   private  Date upTime;//上传时间
   private  Date modifyTime;//修改时间
   private  Integer lookNum;//查看次数
   private  Integer upUser;//上传人
   private  Integer assortmentId;//项目分类
   private  Integer itemState;//项目审核状态
   private  Integer goodNum;//点赞次数
   private  String resourceSrc;//项目压缩包上传路径
   private  Integer weight;//项目权重
   private  String mainImg;//主图路径

   @Override
   public String toString() {
      return "Items{" +
              "id=" + id +
              ", Iname='" + Iname + '\'' +
              ", Itext='" + Itext + '\'' +
              ", upTime=" + upTime +
              ", modifyTime=" + modifyTime +
              ", lookNum=" + lookNum +
              ", upUser='" + upUser + '\'' +
              ", assortmentId=" + assortmentId +
              ", itemState=" + itemState +
              ", goodNum=" + goodNum +
              ", resourceSrc='" + resourceSrc + '\'' +
              ", weight=" + weight +
              ", mainImg='" + mainImg + '\'' +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getIname() {
      return Iname;
   }

   public void setIname(String iname) {
      Iname = iname;
   }

   public String getItext() {
      return Itext;
   }

   public void setItext(String itext) {
      Itext = itext;
   }

   public Date getUpTime() {
      return upTime;
   }

   public void setUpTime(Date upTime) {
      this.upTime = upTime;
   }

   public Date getModifyTime() {
      return modifyTime;
   }

   public void setModifyTime(Date modifyTime) {
      this.modifyTime = modifyTime;
   }

   public Integer getLookNum() {
      return lookNum;
   }

   public void setLookNum(Integer lookNum) {
      this.lookNum = lookNum;
   }

   public Integer getUpUser() {
      return upUser;
   }

   public void setUpUser(Integer upUser) {
      this.upUser = upUser;
   }

   public Integer getAssortmentId() {
      return assortmentId;
   }

   public void setAssortmentId(Integer assortmentId) {
      this.assortmentId = assortmentId;
   }

   public Integer getItemState() {
      return itemState;
   }

   public void setItemState(Integer itemState) {
      this.itemState = itemState;
   }

   public Integer getGoodNum() {
      return goodNum;
   }

   public void setGoodNum(Integer goodNum) {
      this.goodNum = goodNum;
   }

   public String getResourceSrc() {
      return resourceSrc;
   }

   public void setResourceSrc(String resourceSrc) {
      this.resourceSrc = resourceSrc;
   }

   public Integer getWeight() {
      return weight;
   }

   public void setWeight(Integer weight) {
      this.weight = weight;
   }

   public String getMainImg() {
      return mainImg;
   }

   public void setMainImg(String mainImg) {
      this.mainImg = mainImg;
   }
}
