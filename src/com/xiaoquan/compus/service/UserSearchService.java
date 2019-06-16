package com.xiaoquan.compus.service;

import java.util.ArrayList;

import com.xiaoquan.compus.entity.DetailUser;
import com.xiaoquan.compus.entity.Pagination;

public interface UserSearchService {
    public ArrayList<DetailUser> getMoreFriends(int id, Pagination pagination);
    public ArrayList<DetailUser> searchUserByKey(String searchKey, Pagination pagination);
    public boolean cancelFocusFriendById(String userId, String friendId);
    public ArrayList<Integer> findFriendIdByUserId(int userId);
    public boolean addFocusFriendById(String userId, String friendId);
}
