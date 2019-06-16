package com.xiaoquan.compus.mapper;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.DetailUser;
@Repository
public interface UserSearchMapper {
	public int getFriendCountById(int id) throws Exception;
    public ArrayList<DetailUser> findMoreFriends(int id, int offset, int pageSize) throws Exception;
    public int getUserCountByKey(String searchKey) throws Exception;
    public ArrayList<DetailUser> findUserByKey(String searchKey, int offset, int pageSize) throws Exception;
    public int deleteFriendById(String userId, String friendId) throws Exception;
    public ArrayList<Integer> findFriendIdByUserId(int userId) throws Exception;
    public int insertFriendId(String userId, String friendId) throws Exception;
}
