package com.xiaoquan.compus.serviceImp;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.entity.UserFunc;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.exception.ServiceException;
import com.xiaoquan.compus.mapper.UserMapper;
import com.xiaoquan.compus.service.UserService;
@Transactional
@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String email, String password) throws ServiceException {
        if (email.isEmpty() || password.isEmpty()) {
            throw new ServiceException(000, "您不能将邮箱或者密码输入空值！");
        }
        User user = userMapper.findByEmail(email);
        if (user == null) {
            throw new ServiceException(001, "该邮箱未注册！");
        } else {
            if (!password.equals(user.getPassword())) {
                throw new ServiceException(002, "密码错误！");
            } else {
                user.setPassword(null);
                return user;
            }
        }
    }

    @Override
    public int checkEmail(String email) {
        int id;
        try {
            id = userMapper.findEmail(email);
        } catch (Exception e) {
            id = -1;
        }
        return id;
    }

    @Override
    public int checkNickName(String nickName) {
        int id;
        try {
            id = userMapper.findNickName(nickName);
        } catch (Exception e) {
            id = -1;
        }
        return id;
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            userMapper.insertUser(user);
        } catch (Exception e) {
            throw new ServiceException(003, "服务器故障，请稍后重新注册！");
        }
        try {
            for (int i = 0; i < 4; i++ ) {
                UserFunc uf = new UserFunc();
                uf.setUserId(user.getId());
                uf.setFuncId(i+1);
                userMapper.insertFuncs(uf);
            }
        } catch (Exception e) {
            throw new ServiceException(004, "权限授予失败，请稍后重新注册！");
        }

        try {
            int userId = user.getId();
            String path = "G://user_photo//"+ userId;
            File file = new File(path);
            if(!file.exists()&&!file.isDirectory()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            throw new ServiceException(005, "服务器相册文件夹创建失败！");
        }
    }

    @Override
    public boolean changeUserLogoURL(int userId, String logoUrl) {
        try {
            int updateResult = userMapper.updateUserLogoURL(userId, logoUrl);
            return updateResult == 0 ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

}
