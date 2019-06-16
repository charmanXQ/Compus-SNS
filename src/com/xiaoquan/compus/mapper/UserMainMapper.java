package com.xiaoquan.compus.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.User;

@Repository
public interface UserMainMapper {
    public ArrayList<User> findUserById(int id) throws Exception;
    public int getDynamicCountById(int id) throws Exception;
    public ArrayList<Dynamic> findDynamicById(int id) throws Exception;
    public ArrayList<Comment> findParCommentById(int dynamicId) throws Exception;
    public ArrayList<Comment> findSubCommentById(int parCommentId) throws Exception;
    public int updateUserInfo(User user) throws Exception;
    public int deleteDynamicById(int dynamicId) throws Exception;
    public User getOtherUserById(int friendId) throws Exception;
}
