package com.projectShare.service;

import com.projectShare.Pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public void  insertComment(Comment comment);
    public List<Comment> selectCommentForItemID(Integer commentItem);
    public void deleteComment(Integer cid);
}
