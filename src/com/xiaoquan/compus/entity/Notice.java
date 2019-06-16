package com.xiaoquan.compus.entity;

import java.util.Date;

import com.xiaoquan.compus.util.TimeFormat;

public class Notice {
    private int id;
    private String text;
    private Date issueTime;
    private String logoURL;
    private String issueName;
    private String issueType;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getIssueTime() {
        return TimeFormat.getFullDate(issueTime);
    }
    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }
    public String getLogoURL() {
        return logoURL;
    }
    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }
    public String getIssueName() {
        return issueName;
    }
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }
    public String getIssueType() {
        return issueType;
    }
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

}
