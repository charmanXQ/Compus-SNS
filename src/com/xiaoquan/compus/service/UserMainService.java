package com.xiaoquan.compus.service;

import java.util.ArrayList;

import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.User;

public interface UserMainService {
    public ArrayList<User> getFriendList(int id);
    public ArrayList<Dynamic> getDynamicList(int id);
    public void editUserInfo(User user);
    public boolean deleteDynamicById(int dynamicId);
    public User getOtherUserById(int friendId);
}
