package com.xiaoquan.compus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiaoquan.compus.entity.Notice;
import com.xiaoquan.compus.entity.Pagination;

public interface CompusInfoService {
    public Map<String, List<Notice>> getNoticeMap();
    public ArrayList<Notice> queryNotice(String noticeKey, Pagination pagination);
}
