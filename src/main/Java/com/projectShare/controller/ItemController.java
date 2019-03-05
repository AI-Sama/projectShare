package com.projectShare.controller;
import com.alibaba.druid.support.json.JSONUtils;
import com.projectShare.Pojo.Assortment;
import com.projectShare.Pojo.Items;
import com.projectShare.Pojo.ItemsDevelop;
import com.projectShare.Pojo.User;
import com.projectShare.service.AssortmentService;
import com.projectShare.service.ItemService;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/itemController")
public class ItemController {
    @Autowired
    AssortmentService assortmentService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/jumpIndex", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView jumpIndex(){//跳转到首页
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return  modelAndView;
    }


    @RequestMapping(value = "/upItemImg", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String  upItemImg(HttpServletRequest request) {//异步上传图片
        MultipartHttpServletRequest mhs=(MultipartHttpServletRequest) request;
        Iterator<String> iter=mhs.getFileNames();
        String filename=null;
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM");
        String nowDate=s.format(new Date());
        File textFileImg=new File("D:\\ItemSrc\\textImgFile\\"+nowDate);//文本图片储存路径
        if(!textFileImg.exists()){
            textFileImg.mkdir();
        }
        while(iter.hasNext()){
            MultipartFile file=mhs.getFile(iter.next());
            if(file!=null){
                filename= UUID.randomUUID().toString().replaceAll("-","")+".jpg";
                //    File f=new File("D:\\showImg\\SrcImg\\"+filename);
                File f=new File("D:\\ItemSrc\\textImgFile\\"+nowDate+"\\"+filename);
                try {
                    file.transferTo(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // System.out.println("文件名:"+filename);
            }
        }
        //String filepath = "D:\\showImg\\SrcImg\\" + fileName;
        Map<String,String> m=new HashMap<>();
        //m.put("path","/srcImg/"+filename);
        m.put("path","/textImgFile/"+nowDate+"/"+filename);
        return JSONUtils.toJSONString(m);
    }

    @RequestMapping(value = "/jumpUpItem", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView jumpUpItem(){//跳转到上传页面
        ModelAndView modelAndView=new ModelAndView();
        List<Assortment> assortments=assortmentService.selectAssortment();
        modelAndView.addObject("assortments",assortments);
        modelAndView.setViewName("upload");
        return  modelAndView;
    }

    @RequestMapping(value = "/uploadItem", produces = {"text/html;charset=UTF-8;application/json;charset=UTF-8"})//配置方法url路径
    @ResponseBody
    public String uploadItem(HttpServletRequest request, Items items, HttpSession httpSession){//上传项目
        //D:\ItemSrc\
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
            MultipartFile f1=multipartHttpServletRequest.getFile("file1");//主图
            MultipartFile f2=multipartHttpServletRequest.getFile("file2");//压缩包
        if(f2!=null){
            if(f2.getSize()>30240000){
                return "上传文件过大(不得超过30M)";
            }
        }
        if(f1!=null){
            if(f1.getSize()>5240000){
                return "上传图片过大(不得超过5M)";
            }
        }else{
            return "主图不能为空";
        }
        User user=(User)httpSession.getAttribute("user");
        logger.info(items.toString());
        if(user==null){
            return "请先登录";
        }
        itemService.insertItem(f1,f2,items,user);
        return "上传成功";
    }

    @RequestMapping(value = "/loadItems", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String loadItems(Integer assortmentId, Integer pageCount, HttpSession httpSession){
        //显示分类项目
        if(pageCount==null||pageCount<1){
            pageCount=1;
        }
//        ModelAndView m=new ModelAndView();
          List<ItemsDevelop> items=itemService.selectItems(assortmentId,pageCount);
          httpSession.setAttribute("itemLists",items);
//        httpSession.setAttribute("pageCount",pageCount);//储存当前页数
//        Integer allPageCount=itemService.selectCountItem();//全部页数
//        httpSession.setAttribute("allPageCount",allPageCount);//储存全部页数
//        m.addObject("items",items);
        JSONArray jsonArray=new JSONArray(items);
        return jsonArray.toString();
    }

    @RequestMapping(value = "/deleteItems", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public ModelAndView deleteItems(Items items ,HttpSession httpSession){//删除项目
        itemService.deleteItems(items.getId());
        ModelAndView m=new ModelAndView();
        return m;
    }

    @RequestMapping(value = "/changeItems", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public ModelAndView changeItems(Items items ,HttpSession httpSession){//修改项目
        ModelAndView m=new ModelAndView();
        itemService.changeItem(items);
        return m;
    }

    @RequestMapping(value = "/selectAllAuditingItems", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView selectAllAuditingItems(){//查找所有未审核的项目
        ModelAndView m=new ModelAndView();
       List<ItemsDevelop> items=itemService.selectAllAuditingItems();
       m.addObject("auditingItems",items);
        return m;
    }

    @RequestMapping(value = "/changeItemState", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String changeItemState(Integer state,Integer id){//审核项目
        itemService.changeItemState(state,id);
        return "success";
    }

    @RequestMapping(value = "/loadBigItem", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView loadBigItem(HttpSession httpSession,Integer itemId){//加载项目详情
        ModelAndView m=new ModelAndView();
        m.setViewName("proShow");
       List<ItemsDevelop> itemsDevelops=(List<ItemsDevelop>)httpSession.getAttribute("itemLists");//从session取出项目集合
        if(itemsDevelops!=null){
            for (ItemsDevelop item:itemsDevelops
            ) {
                if(item.getId()==itemId){//如果项目id等于传过来的id,就存到modelandview里,然后返回
                    m.addObject("item",item);
                    break;
                }
            }
        }
        return m;
    }
}
