package com.xiaoquan.compus.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoquan.compus.entity.DetailUser;
import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.service.UserSearchService;
import com.xiaoquan.compus.util.StringUtil;

@Controller
public class UserSearchController {
    @Resource(name="userSearchService")
    private UserSearchService userSearchService;
    //更多好友
    @RequestMapping("moreFriends.do")
    public String moreFriends(HttpSession session, Model model, String currentPage) {
        Pagination pagination = new Pagination();

        if (StringUtil.isEmpty(currentPage)) {
            currentPage = "1";
        }

        int curPage = Integer.valueOf(currentPage);
        if (curPage < 1) {
            curPage = 1;
        }

        pagination.setCurrentPage(curPage);
        pagination.setPageSize(5);

        User curUser = (User)session.getAttribute("USER");
        ArrayList<DetailUser> friends = userSearchService.getMoreFriends(curUser.getId(), pagination);
        model.addAttribute("FriendList", friends);
        model.addAttribute("pagination", pagination);
        return "user_jsp/moreFriends";
    }

    //根据关键字搜索
    @RequestMapping("searchUserByKey.do")
    public String searchUserByKey(HttpSession session, Model model, String searchKey, String currentPage) {
        Pagination pagination = new Pagination();

        if (StringUtil.isEmpty(currentPage)) {
            currentPage = "1";
        }

        int curPage = Integer.valueOf(currentPage);
        if (curPage < 1) {
            curPage = 1;
        }

        pagination.setCurrentPage(curPage);
        pagination.setPageSize(10);

        User curUser = (User)session.getAttribute("USER");
        ArrayList<DetailUser> searchUsers = userSearchService.searchUserByKey(searchKey, pagination);
        ArrayList<Integer> friendIds = userSearchService.findFriendIdByUserId(curUser.getId());
        model.addAttribute("searchUsers", searchUsers);
        model.addAttribute("pagination", pagination);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("friendIds", friendIds);
        return "user_jsp/userSearch";
    }

    //取消已关注的好友
    @RequestMapping("cancelFocusFriend.do")
    @ResponseBody
    public boolean cancelFocusFriend(String userId, String friendId) {
        boolean flag = userSearchService.cancelFocusFriendById(userId, friendId);
        return flag;
    }

    //添加好友
    @RequestMapping("addFocusFriend.do")
    @ResponseBody
    public boolean addFocusFriend(String userId, String friendId) {
        boolean flag = userSearchService.addFocusFriendById(userId, friendId);
        return flag;
    }

}
