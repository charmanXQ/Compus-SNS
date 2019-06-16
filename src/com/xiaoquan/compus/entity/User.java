package com.xiaoquan.compus.entity;

import java.util.List;

public class User {
    private int id;
    private String nickName;
    private boolean sex;
    private String email;
    private String college;
    private String password;
    private String logoUrl;
    private List<Function> funcs;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLogoUrl() {
        return logoUrl;
    }
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
    public List<Function> getFuncs() {
        return funcs;
    }
    public void setFuncs(List<Function> funcs) {
        this.funcs = funcs;
    }


}
