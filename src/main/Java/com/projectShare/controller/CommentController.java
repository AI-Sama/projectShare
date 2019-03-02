package com.projectShare.controller;

import com.projectShare.Pojo.Comment;
import com.projectShare.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/commentController")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/publishComment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public void publishComments(Comment comment, HttpSession httpSession){//发布评论
                        commentService.insertComment(comment);
    }
    @RequestMapping(value = "/deleteComment", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public void deleteComments(Comment comment, HttpSession httpSession){//删除评论
                commentService.deleteComment(comment.getCid());
    }
    @RequestMapping(value = "/selectCommentForItemID", produces = {"text/html;charset=UTF-8;"})//配置方法url路径
    public void selectCommentForItemID(Comment comment, HttpSession httpSession){//根据项目id查找评论
        commentService.selectCommentForItemID(comment.getCid());
    }

}
