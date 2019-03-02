package com.projectShare.mapper;


import com.projectShare.Pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//自动生成的分类mapper
public interface CommentMapper {
        public void insertComment(Comment comment);//增加一個評論
        public List<Comment> selectCommentForItemID(@Param(value ="commentItem" ) Integer commentItem);//根据项目id查找评论
        public void deleteComment(@Param(value ="cid" )Integer cid);//删除一条评论
}