package com.xiaoquan.compus.serviceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.FriendDynamicMapper;
import com.xiaoquan.compus.mapper.UserMainMapper;
import com.xiaoquan.compus.service.FriendDynamicService;
@Service("friendDynamicService")
public class FriendDynamicServiceImp implements FriendDynamicService {
    @Autowired
    private FriendDynamicMapper friendDynamicMapper;

    @Autowired
    private UserMainMapper userMainMapper;

	@Override
	public ArrayList<Dynamic> getFriendDynamicList(int id) {
        try {
            ArrayList<Dynamic> friendDynamics = friendDynamicMapper.findFriendDynamicById(id);
            for (Dynamic dynamic : friendDynamics) {
                int dynamicId = dynamic.getId();
                ArrayList<Comment> parComments = userMainMapper.findParCommentById(dynamicId);
                for (Comment parComment : parComments ) {
                    int parCommentId = parComment.getId();
                    ArrayList<Comment> subComments = userMainMapper.findSubCommentById(parCommentId);
                    parComment.setSubComment(subComments);
                }
                dynamic.setParComment(parComments);
            }
            return friendDynamics;
        } catch (Exception e) {
            throw new DBException();
        }
	}

}
