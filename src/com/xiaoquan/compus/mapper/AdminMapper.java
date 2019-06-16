package com.xiaoquan.compus.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.Notice;

@Repository
public interface AdminMapper {

    public ArrayList<Dynamic> findDynamic(String dynamicKey, int offest, int pageSize) throws Exception;
    public int getKeyDynamicCount(String dynamicKey) throws Exception;
    public int addNotice(Notice notice) throws Exception;
    public int deleteNoticeById(int noticeId) throws Exception;
    public int deleteFuncById(int userId) throws Exception;
    public int addFuncById(int userId, int funcId) throws Exception;

}
