package com.xiaoquan.compus.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.UserIssueMapper;
import com.xiaoquan.compus.service.UserIssueService;
@Service("userIssueService")
public class UserIssueServiceImp implements UserIssueService {
    @Autowired
    public UserIssueMapper userIssueMapper;
    @Override
    public int getDynamicCountByUserId(int id) {
        try {
            return userIssueMapper.countDynamicByUserId(id);
        } catch (Exception e) {
            throw new DBException();
        }
    }

    @Override
    public boolean pushDynamic(Dynamic dynamic) {
        try {
            int addResult = userIssueMapper.addDynamic(dynamic);
            return addResult == 0 ? false : true;
        } catch (Exception e) {
            throw new DBException();
        }
    }

    @Override
    public boolean pushParComment(Comment comment) {
        try {
            int addResult = userIssueMapper.addParComment(comment);
            return addResult == 0 ? false : true;
        } catch (Exception e) {
            throw new DBException();
        }
    }

    @Override
    public boolean pushSubComment(Comment comment) {
        try {
            int addResult = userIssueMapper.addSubComment(comment);
            return addResult == 0 ? false : true;
        } catch (Exception e) {
            throw new DBException();
        }
    }
}
