package com.xiaoquan.compus.service;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;

public interface UserIssueService {
    public int getDynamicCountByUserId(int id);
    public boolean pushDynamic(Dynamic dynamic);
    public boolean pushParComment(Comment comment);
    public boolean pushSubComment(Comment comment);
}
