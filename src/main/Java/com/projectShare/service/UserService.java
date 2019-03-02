package com.projectShare.service;

import com.projectShare.Pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    public String insertUser(User user);
    public User selectUserForStuID(String stuID);
    public void changeUser(User user);
    public User selectUserForID(Integer id);
    public void changePassword(Integer id,String password);
}
