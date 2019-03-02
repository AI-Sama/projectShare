package com.projectShare.Pojo;

import java.util.Date;

public class Comment {
    private  Integer cid;//评论id(主键)
    private  String commentUser;//评论人
    private  Integer commentItem;//评论项目id
    private  String commentText;//评论内容
    private Date commentTime;//评论时间

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public Integer getCommentItem() {
        return commentItem;
    }

    public void setCommentItem(Integer commentItem) {
        this.commentItem = commentItem;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
