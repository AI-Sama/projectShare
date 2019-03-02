package com.projectShare.serviceImpl;

import com.projectShare.Pojo.User;
import com.projectShare.mapper.UserMapper;
import com.projectShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String insertUser(User user) {
        if(user.getStuID()==null||user.getNickName()==null||user.getPassword()==null){
            return "学号丶昵称丶密码不能为空";
        }
        if(userMapper.selectNickName(user.getNickName())!=null){
            return "该昵称已被注册";
        }
        if(userMapper.selectUserForStuID(user.getStuID())!=null){
            return "该学号已被注册";
        }
        try {
            userMapper.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "注册失败";
        }
     return "注册成功";
    }

    @Override
    public User selectUserForStuID(String stuID) {
        User user=userMapper.selectUserForStuID(stuID);
        return user;
    }

    @Override
    public void changeUser(User user) {
        userMapper.changeUser(user);
    }

    @Override
    public User selectUserForID(Integer id) {
        return userMapper.selectUserForID(id);
    }

    @Override
    public void changePassword(Integer id, String password) {
            userMapper.changePassword(id,password);
    }
}
