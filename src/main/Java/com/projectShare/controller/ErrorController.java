package com.projectShare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
    @RequestMapping(value = "*")//*的优先级最低,所以如果找不到其他匹配的路径,就会跳到这个页面,进行404处理
    public ModelAndView pageNotFound() {
        //统一404处理
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("404Error");
        return modelAndView;
    }
}
