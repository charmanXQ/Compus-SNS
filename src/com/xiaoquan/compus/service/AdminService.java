package com.xiaoquan.compus.service;

import java.util.ArrayList;

import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.Notice;
import com.xiaoquan.compus.entity.Pagination;

public interface AdminService {

    public ArrayList<Dynamic> getDynamicList(String dynamicKey, Pagination pagination);
    public boolean pushNotice(Notice notice);
    public boolean deleteNoticeById(int noticeId);
    public boolean resetFunc(int[] FuncIds, int userId);
}
