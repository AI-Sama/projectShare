package com.projectShare.serviceImpl;

import com.projectShare.Pojo.Comment;
import com.projectShare.mapper.CommentMapper;
import com.projectShare.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public List<Comment> selectCommentForItemID(Integer commentItem) {
        List<Comment> comments=commentMapper.selectCommentForItemID(commentItem);
        return comments;
    }

    @Override
    public void deleteComment(Integer cid) {
          commentMapper.deleteComment(cid);
    }
}
