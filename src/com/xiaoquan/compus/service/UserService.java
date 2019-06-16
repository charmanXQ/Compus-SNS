package com.xiaoquan.compus.service;

import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.exception.ServiceException;

public interface UserService {
    public User checkUser(String email, String password) throws ServiceException;
    public int checkEmail(String email);
    public int checkNickName(String nickName);
    public void addUser(User user) throws ServiceException;
    public boolean changeUserLogoURL(int userId, String logoUrl);
}
