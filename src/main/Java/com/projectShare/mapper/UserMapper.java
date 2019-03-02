package com.projectShare.mapper;


import com.projectShare.Pojo.User;
import org.apache.ibatis.annotations.Param;

//自动生成的分类mapper
public interface UserMapper {
        public void insertUser(User user);//新增一个用户
        public User selectUserForStuID(@Param(value = "stuID") String stuID);//根据学号查找用户
        public User selectNickName(@Param(value = "nickName") String nickName);//根据昵称查找用户
        public void changeUser(User user);//修改||完善信息
        public User selectUserForID(@Param(value = "id")Integer id);//根据id查找用户
        public void changePassword(@Param(value = "id")Integer id,@Param(value = "password")String password);//修改密码
}