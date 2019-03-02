package com.projectShare.serviceImpl;

import com.projectShare.Pojo.Items;
import com.projectShare.Pojo.ItemsDevelop;
import com.projectShare.Pojo.User;
import com.projectShare.mapper.ItemsMapper;
import com.projectShare.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public String insertItem(MultipartFile f1,MultipartFile f2, Items items, User user){//上传项目
        if(items.getIname()==null){
            return "项目名不能为空";
        }else if(items.getItext()==null){
            return  "项目介绍不能为空";
        }
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM");
        String nowDate=s.format(new Date());
        File f1Dir=new File("D:\\ItemSrc\\imgFile\\"+nowDate);//图片储存路径
        File f2Dir=new File("D:\\ItemSrc\\zipFile\\"+nowDate);//压缩包储存路径
        if(!f1Dir.exists()){
            f1Dir.mkdir();
        }
        if(!f2Dir.exists()){
            f2Dir.mkdir();
        }
        String str= UUID.randomUUID().toString().replaceAll("-","");//uuid码
        File imgFilePath=new File("D:\\ItemSrc\\imgFile\\"+nowDate+"\\"+str+".jpg");
        try {
            if(f2!=null){
                String file2Mime=f2.getOriginalFilename().substring(f2.getOriginalFilename().lastIndexOf("."));//压缩包后缀名
                File zipFilePath=new File("D:\\ItemSrc\\zipFile\\"+nowDate+"\\"+str+"."+file2Mime);
                f2.transferTo(zipFilePath);
                items.setResourceSrc(nowDate+"\\"+str+file2Mime);//设置压缩包储存路径
            }
            f1.transferTo(imgFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传出错";
        }
        items.setMainImg(nowDate+"\\"+str+".jpg");//设置主图路径
        items.setUpUser(user.getId());//设置上传者id
        itemsMapper.insertItem(items);
        return "上传成功,待管理员审核";
    }

    @Override
    public List<ItemsDevelop> selectItems(Integer assortmentId, Integer pageCount) {//查找分类项目
        int star=pageCount==1? 0 :(pageCount-1)*8;
        List<ItemsDevelop> items=itemsMapper.selectItems(assortmentId,star);
        return items;
    }

    @Override
    public Integer selectCountItem(){//查找页数
       Integer count= itemsMapper.selectCountItem();
       int AllpageCount=count%8==0? count/8 :(count/8+1);
        return count;
    }

    @Override
    public void deleteItems(Integer id) {
        itemsMapper.deleteItems(id);
    }

    @Override
    public void changeItem(Items items) {
        itemsMapper.changeItem(items);
    }

    @Override
    public List<ItemsDevelop> selectAllAuditingItems(){
        List<ItemsDevelop> items=  itemsMapper.selectAllAuditingItems();
        return items;
    }

    @Override
    public void changeItemState(Integer itemState,Integer id) {
        itemsMapper.changeItemState(itemState,id);
    }

    @Override
    public List<ItemsDevelop> selectItemsForUser(Integer userId, Integer star) {
                 int start=star==1? 0 :(star-1)*8;
        List<ItemsDevelop> itemsDevelops=itemsMapper.selectItemsForUser(userId,start);
        return itemsDevelops;
    }
}