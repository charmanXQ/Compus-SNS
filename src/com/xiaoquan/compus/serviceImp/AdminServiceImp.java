package com.xiaoquan.compus.serviceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.Notice;
import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.AdminMapper;
import com.xiaoquan.compus.mapper.UserMainMapper;
import com.xiaoquan.compus.service.AdminService;
@Service("adminService")
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMainMapper userMainMapper;

    @Override
    public ArrayList<Dynamic> getDynamicList(String dynamicKey, Pagination pagination) {
        try {
            pagination.setTotalCount(adminMapper.getKeyDynamicCount(dynamicKey));
            ArrayList<Dynamic> dynamics = adminMapper.findDynamic(dynamicKey, pagination.getOffset(), pagination.getPageSize());
            for (Dynamic dynamic : dynamics) {
                int dynamicId = dynamic.getId();
                ArrayList<Comment> parComments = userMainMapper.findParCommentById(dynamicId);
                for (Comment parComment : parComments ) {
                    int parCommentId = parComment.getId();
                    ArrayList<Comment> subComments = userMainMapper.findSubCommentById(parCommentId);
                    parComment.setSubComment(subComments);
                }
                dynamic.setParComment(parComments);
            }
            return dynamics;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public boolean pushNotice(Notice notice) {
        try {
            int addResult = adminMapper.addNotice(notice);
            return addResult == 0 ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean deleteNoticeById(int noticeId) {
        try {
            int resultId = adminMapper.deleteNoticeById(noticeId);
            return resultId > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
	}

	@Override
	public boolean resetFunc(int[] funcIds, int userId) {
        boolean flag = false;
        try {
            adminMapper.deleteFuncById(userId);
            for (int funcId : funcIds) {
                adminMapper.addFuncById(userId, funcId);
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
        return flag;
	}


}
