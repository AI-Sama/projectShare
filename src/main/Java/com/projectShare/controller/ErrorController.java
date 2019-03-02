package com.projectShare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
    @RequestMapping(value = "*")
    public ModelAndView pageNotFound() {//统一404处理
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("404Error");
        return modelAndView;
    }
}
