package com.xiaoquan.compus.serviceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.DetailUser;
import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.UserSearchMapper;
import com.xiaoquan.compus.service.UserSearchService;
@Service("userSearchService")
public class UserSearchServiceImp implements UserSearchService {
    @Autowired
    private UserSearchMapper userSearchMapper;

    @Override
    public ArrayList<DetailUser> getMoreFriends(int id, Pagination pagination) {
        try {
            int totalCount = userSearchMapper.getFriendCountById(id);
            pagination.setTotalCount(totalCount);
            return userSearchMapper.findMoreFriends(id, pagination.getOffset(), pagination.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public ArrayList<DetailUser> searchUserByKey(String searchKey, Pagination pagination) {
        try {
            int totalCount = userSearchMapper.getUserCountByKey(searchKey);
            pagination.setTotalCount(totalCount);
            ArrayList<DetailUser> list = userSearchMapper.findUserByKey(searchKey, pagination.getOffset(), pagination.getPageSize());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public boolean cancelFocusFriendById(String userId, String friendId) {
        try {
            int resultId = userSearchMapper.deleteFriendById(userId, friendId);
            return resultId > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public ArrayList<Integer> findFriendIdByUserId(int userId) {
        try {
            return userSearchMapper.findFriendIdByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public boolean addFocusFriendById(String userId, String friendId) {
        try {
            int resultId = userSearchMapper.insertFriendId(userId, friendId);
            return resultId > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }
}
