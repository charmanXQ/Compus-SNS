package com.xiaoquan.compus.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.service.UserMainService;

@Controller
public class UserMainController {
    @Resource(name="userMainService")
    private UserMainService userMainService;

    //进入主页或者个人中心
    @RequestMapping("userMain.do")
    public String userMain(HttpSession session, Model model) {
        User curUser = (User)session.getAttribute("USER");
        ArrayList<User> friends = userMainService.getFriendList(curUser.getId());
        model.addAttribute("FriendList", friends);
        return "user_jsp/userMain";
    }
    //自己的动态
    @RequestMapping("dynamic.do")
    public String getDynamicList(HttpSession session, Model model) {
        User curUser = (User)session.getAttribute("USER");
        ArrayList<Dynamic> dynamics = userMainService.getDynamicList(curUser.getId());
        model.addAttribute("DynamicList", dynamics);
        model.addAttribute("TitleName", "我的动态");
        return "common/dynamic";
    }

    //编辑信息
    @RequestMapping("editUserInfo.do")
    public String editUserInfo(HttpSession session, User user) {
        User curUser = (User)session.getAttribute("USER");
        curUser.setNickName(user.getNickName());
        curUser.setCollege(user.getCollege());
        user.setId(curUser.getId());
        userMainService.editUserInfo(user);
        return "redirect: userMain.do";
    }

    //删除动态
    @RequestMapping("deleteDynamic.do")
    @ResponseBody
    public boolean deleteDyamicById(int dynamicId) {
        boolean flag = userMainService.deleteDynamicById(dynamicId);
        return flag;
    }

    //进入好友主页
    @RequestMapping("friendMain.do")
    public String friendMain(HttpSession session, int friendId, Model model) {
        User otherUser = userMainService.getOtherUserById(friendId);
        ArrayList<User> friends = userMainService.getFriendList(friendId);
        session.setAttribute("otherUser", otherUser);
        model.addAttribute("FriendList", friends);
        model.addAttribute("isOtherMainPage", true);
        return "user_jsp/otherUserMain";
    }

    //好友页面动态的
    //自己的动态
    @RequestMapping("otherDynamic.do")
    public String getFriendDynamicList(HttpSession session, Model model) {
        User otherUser = (User)session.getAttribute("otherUser");
        ArrayList<Dynamic> dynamics = userMainService.getDynamicList(otherUser.getId());
        model.addAttribute("DynamicList", dynamics);
        model.addAttribute("TitleName", "动态");
        model.addAttribute("isOtherMainPage", true);
        return "common/dynamic";
    }
}
