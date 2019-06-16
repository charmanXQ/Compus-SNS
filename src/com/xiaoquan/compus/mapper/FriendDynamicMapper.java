package com.xiaoquan.compus.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.Dynamic;

@Repository
public interface FriendDynamicMapper {
    public ArrayList<Dynamic> findFriendDynamicById(int userId) throws Exception;
}
