package com.xiaoquan.compus.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoquan.compus.entity.Comment;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.service.UserIssueService;

@Controller
public class UserIssueController {
    @Resource(name="userIssueService")
    private UserIssueService userIssueService;

    @RequestMapping("userIssue.do")
    public String userIssue(HttpSession session, Model model) {
        User user = (User)session.getAttribute("USER");
        int dyCount = userIssueService.getDynamicCountByUserId(user.getId());
        model.addAttribute("DyCount", dyCount);
        return "user_jsp/userIssue";
    }
    //发布动态
    @RequestMapping("pushDynamic.do")
    @ResponseBody
    public boolean pushDynamic(Dynamic dynamic) {
        boolean flag = userIssueService.pushDynamic(dynamic);
        return flag;
    }

    //父评论
    @RequestMapping("pushParComment.do")
    @ResponseBody
    public boolean pushParComment(Comment comment) {
        boolean flag = userIssueService.pushParComment(comment);
        return flag;
    }

    //子评论
    @RequestMapping("pushSubComment.do")
    @ResponseBody
    public boolean pushSubComment(Comment comment) {
        boolean flag = userIssueService.pushSubComment(comment);
        return flag;
    }
}
