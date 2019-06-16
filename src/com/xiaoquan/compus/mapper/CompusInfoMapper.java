package com.xiaoquan.compus.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.Notice;

@Repository
public interface CompusInfoMapper {
    public List<Notice> getNoticeListById(int id) throws Exception;
    public ArrayList<Notice> getNoticeList(String noticeKey, int offset, int pageSize) throws Exception;
    public int getNoticeTotalCount() throws Exception;
}
