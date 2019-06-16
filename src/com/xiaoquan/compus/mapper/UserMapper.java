package com.xiaoquan.compus.mapper;


import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.entity.UserFunc;
@Repository
public interface UserMapper {
    public User findByEmail(String email);
    public int findEmail(String email) throws Exception;
    public int findNickName(String nickName) throws Exception;
    public int insertUser(User user) throws Exception;
    public int insertFuncs(UserFunc uf) throws Exception;
    public int updateUserLogoURL(int userId, String logoUrl) throws Exception;
}
