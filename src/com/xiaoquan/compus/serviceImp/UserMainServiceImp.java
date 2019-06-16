package com.xiaoquan.compus.serviceImp;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.UserMainMapper;
import com.xiaoquan.compus.service.UserMainService;
@Service("userMainService")
public class UserMainServiceImp implements UserMainService {
    @Autowired
    private UserMainMapper userMainMapper;

    @Override
    public ArrayList<User> getFriendList(int id) {
        try {
            ArrayList<User> newlist = new ArrayList<User>();
            ArrayList<User> list = userMainMapper.findUserById(id);
            int size = list.size();
            if (size <= 5) {
                return list;
            }
            int index = new Random().nextInt(list.size()-5);
            for (int i = index; i < index+5; i++) {
                newlist.add(list.get(i));
            }
            return newlist;
        } catch (Exception e) {
            throw new DBException();
        }
    }

    @Override
    public ArrayList<Dynamic> getDynamicList(int id) {
        try {
            ArrayList<Dynamic> dynamics = userMainMapper.findDynamicById(id);
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
    public void editUserInfo(User user) {
        try {
            userMainMapper.updateUserInfo(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

	@Override
	public boolean deleteDynamicById(int dynamicId) {
        try {
            int resultId = userMainMapper.deleteDynamicById(dynamicId);
            return resultId > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
	}

	@Override
	public User getOtherUserById(int friendId) {
        try {
            return userMainMapper.getOtherUserById(friendId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
	}
}
