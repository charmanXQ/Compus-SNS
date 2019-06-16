package com.xiaoquan.compus.entity;

import java.util.Date;
import java.util.List;

import com.xiaoquan.compus.util.TimeFormat;

public class Comment {
    private int id;
    private String txtComment;
    private Date commentTime;
    private String replyToUserName;
    private User commentUser;
    private List<Comment> subComment;
    private int dynamicId;
    private int parCommentId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTxtComment() {
        return txtComment;
    }
    public void setTxtComment(String txtComment) {
        this.txtComment = txtComment;
    }
    public String getCommentTime() {
        return TimeFormat.getFullDate(commentTime);
    }
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getReplyToUserName() {
        return replyToUserName;
    }
    public void setReplyToUserName(String replyToUserName) {
        this.replyToUserName = replyToUserName;
    }
    public User getCommentUser() {
        return commentUser;
    }
    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }
    public List<Comment> getSubComment() {
        return subComment;
    }
    public void setSubComment(List<Comment> subComment) {
        this.subComment = subComment;
    }
    public int getDynamicId() {
        return dynamicId;
    }
    public void setDynamicId(int dynamicId) {
        this.dynamicId = dynamicId;
    }
    public int getParCommentId() {
        return parCommentId;
    }
    public void setParCommentId(int parCommentId) {
        this.parCommentId = parCommentId;
    }

}
