package com.xiaoquan.compus.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.service.FriendDynamicService;

@Controller
public class FriendDynamicController {
    @Resource(name="friendDynamicService")
    private FriendDynamicService friendDynamicService;
    //���Ѷ�̬
    @RequestMapping("friendDynamic.do")
    public String friendDynamic(HttpSession session, Model model) {
        return "user_jsp/friendDynamic";
    }
    //���ѵĶ�̬
    @RequestMapping("addFriendDynamic.do")
    public String getFriendDynamicList(HttpSession session, Model model) {
        User curUser = (User)session.getAttribute("USER");
        ArrayList<Dynamic> dynamics = friendDynamicService.getFriendDynamicList(curUser.getId());
        model.addAttribute("DynamicList", dynamics);
        model.addAttribute("TitleName", "����Ȧ");
        return "common/dynamic";
    }
}
