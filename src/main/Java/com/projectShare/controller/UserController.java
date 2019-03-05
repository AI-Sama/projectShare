package com.projectShare.controller;
import com.projectShare.Pojo.Assortment;
import com.projectShare.Pojo.ItemsDevelop;
import com.projectShare.Pojo.User;
import com.projectShare.service.AssortmentService;
import com.projectShare.service.ItemService;
import com.projectShare.service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    AssortmentService assortmentService;
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/jumpLoginPage", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView  jumpLoginPage() {//跳转到登录页面
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = "/jumpPersonPage", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public ModelAndView  jumpPersonPage(HttpSession httpSession) {//跳转到个人中心页面
        ModelAndView modelAndView=new ModelAndView();
        User user=(User)httpSession.getAttribute("user");
        if(user==null){
            modelAndView.setViewName("login");
            return modelAndView;
        }
        List<Assortment> assortments=assortmentService.selectAssortment();
        if(user.getUserLv()>1){
            List<ItemsDevelop> itemsDevelops=itemService.selectAllAuditingItems();//获取未审核的项目
            httpSession.setAttribute("items",itemsDevelops);
        }
        List<ItemsDevelop> itemsDevelops=itemService.selectItemsForUser(user.getId(),1);//获取用户的项目
        httpSession.setAttribute("itemLists",itemsDevelops);
        modelAndView.addObject("assortments",assortments);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("person");
        return modelAndView;
    }

    @RequestMapping(value = "/signUp", produces = {"text/html;charset=UTF-8;application/json;charset=UTF-8"})//配置方法url路径
    @ResponseBody
    public String  signUp(@RequestBody User user) {//注册
        ModelAndView modelAndView=new ModelAndView();
        String b = userService.insertUser(user);
        return b;
    }

    @RequestMapping(value = "/signIn", produces = {"text/html;charset=UTF-8;application/json;charset=UTF-8"})//配置方法url路径
    @ResponseBody
    public String signIn(@RequestBody User user, HttpSession httpSession) {//登录
        ModelAndView modelAndView=new ModelAndView();
        if(user.getStuID()==null||user.getStuID().trim().length()<=0){
            return "学号不能为空";
        }
        User user1 = userService.selectUserForStuID(user.getStuID());//通过学号查找用户
        if(user1==null){
            return "账号不存在";
        }
        if (user1.getPassword().equals(user.getPassword())) {//密码相同,登录成功
            user1.setPassword("");
            httpSession.setAttribute("user",user1);
            return "登录成功";
        }else{
            return "账号或密码错误";
        }
    }
    @RequestMapping(value = "/exitLogin", produces = {"text/html;charset=UTF-8;application/json;charset=UTF-8"})//配置方法url路径
    public ModelAndView exitLogin( HttpSession httpSession) {//退出登录
        httpSession.removeAttribute("user");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/changeUser", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String changeUser(User user, HttpSession httpSession) {//修改||完善信息
            //System.out.println(user);
            userService.changeUser(user);
        return "修改成功,重新登录后生效";
    }
    @RequestMapping(value = "/changePassword", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String changePassword(Integer userId, String oldPassword,String password,HttpSession httpSession) {//修改密码
        User user=userService.selectUserForID(userId);
        if(!user.getPassword().equals(oldPassword)){
            return "原密码不正确";
        }else{
            userService.changePassword(userId,password);
        }
        return "修改成功";
    }

    @RequestMapping(value = "/changeAuditingItems", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    @ResponseBody
    public String changeAuditingItems(Integer id, HttpSession httpSession) {//修改审核项目显示的项目
        List<ItemsDevelop> itemsDevelops=(List<ItemsDevelop>) httpSession.getAttribute("items");
        String str="";
        JSONObject jsonObject=null;
        for (ItemsDevelop item:itemsDevelops
             ) {
                if(item.getId()==id){//如果传过来的项目id等于session里的项目id,返回这个项目
                    jsonObject=new JSONObject(item);
                    break;
                }
        }
        return jsonObject.toString();
    }
}
