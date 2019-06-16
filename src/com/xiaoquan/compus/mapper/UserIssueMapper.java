package com.xiaoquan.compus.mapper;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;

@Repository
public interface UserIssueMapper {
    public int countDynamicByUserId(int userId) throws Exception;
    public int addDynamic(Dynamic dynamic) throws Exception;
    public int addParComment(Comment comment) throws Exception;
    public int addSubComment(Comment comment) throws Exception;
}
