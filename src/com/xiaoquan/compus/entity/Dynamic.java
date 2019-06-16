package com.xiaoquan.compus.entity;


import java.util.Date;
import java.util.List;

import com.xiaoquan.compus.util.TimeFormat;

public class Dynamic {
    private int id;
    private String txtWords;
    private Date issueTime;
    private User issueUser;
    private List<Comment> parComment;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTxtWords() {
        return txtWords;
    }
    public void setTxtWords(String txtWords) {
        this.txtWords = txtWords;
    }
    public String getIssueTime() {
        return TimeFormat.getFullDate(issueTime);
    }
    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }
    public User getIssueUser() {
        return issueUser;
    }
    public void setIssueUser(User issueUser) {
        this.issueUser = issueUser;
    }
    public List<Comment> getParComment() {
        return parComment;
    }
    public void setParComment(List<Comment> parComment) {
        this.parComment = parComment;
    }
}
