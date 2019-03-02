package com.projectShare.controller;

import com.projectShare.Pojo.Assortment;
import com.projectShare.Pojo.ItemsDevelop;
import com.projectShare.service.AssortmentService;
import com.projectShare.service.ItemService;
import com.sun.org.apache.regexp.internal.RE;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/assortmentController")
public class AssortmentController {

    @Autowired
    AssortmentService assortmentService;
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/jumpAssortment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView jumpAssortment(Assortment assortment, HttpSession httpSession){//跳转到分类页面
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("classify");
        List<Assortment> assortments=assortmentService.selectAssortment();
        List<ItemsDevelop> itemLists=itemService.selectItems(assortments.get(0).getId(),1);
        httpSession.setAttribute("itemLists",itemLists);
        modelAndView.addObject("assortments",assortments);
        modelAndView.addObject("itemLists",itemLists);
        return  modelAndView;
    }

    @RequestMapping(value = "/addAssortment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String addAssortment(Assortment assortment, HttpSession httpSession){//添加分类
                        assortmentService.insertAssortment(assortment);
                        return "添加成功";
    }

    @RequestMapping(value = "/deleteAssortment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String deleteAssortment(Assortment assortment, HttpSession httpSession){//删除分类
                        assortmentService.deleteAssortment(assortment);
        return "删除成功";
    }

    @RequestMapping(value = "/changeAssortment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public void changeAssortment(Assortment assortment, HttpSession httpSession){//修改分类
                        assortmentService.changeAssortment(assortment);
    }

    @RequestMapping(value = "/selectAssortment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String selectAssortment( HttpSession httpSession){//查找分类
                List<Assortment> assortments=assortmentService.selectAssortment();
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.addObject("assortments",assortments);
               JSONArray jsonArray=new JSONArray(assortments);
                return jsonArray.toString();
    }
}
