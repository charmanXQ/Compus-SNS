package com.xiaoquan.compus.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xiaoquan.compus.entity.DetailUser;
import com.xiaoquan.compus.entity.Dynamic;
import com.xiaoquan.compus.entity.Notice;
import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.entity.Picture;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.exception.ServiceException;
import com.xiaoquan.compus.service.AdminService;
import com.xiaoquan.compus.service.CompusInfoService;
import com.xiaoquan.compus.service.UserAlbumService;
import com.xiaoquan.compus.service.UserSearchService;
import com.xiaoquan.compus.service.UserService;
import com.xiaoquan.compus.util.MD5Util;
import com.xiaoquan.compus.util.StringUtil;

@Controller
public class AdminController {
    @Resource(name="adminService")
    private AdminService adminService;

    @Resource(name="userService")
    private UserService userService;

    @Resource(name="userSearchService")
    private UserSearchService userSearchService;

    @Resource(name="userAlbumService")
    private UserAlbumService userAlbumService;

    @Resource(name="compusInfoService")
    private CompusInfoService compusInfoService;

    //响应登录请求
    @RequestMapping("adminLogin.do")
    public String adminLogin() {
        return "admin_jsp/adminLogin";
    }

    //检查用户登录
    @RequestMapping("checkAdmin.do")
    public String userLogin(Model model, RedirectAttributes redirectAttributes, String email, String password, HttpSession session) {
        try {
            String md5Pwd = MD5Util.md5(password);
            User user = userService.checkUser(email, md5Pwd);
            session.setAttribute("Admin", user);
            model.addAttribute("defaultTab", "userManage");
            return "redirect:adminMain.do";
        } catch (ServiceException se) {
            redirectAttributes.addFlashAttribute("ErrorMessage", "[" + se.getErrorCode() + "]" + se.getErrorMessage());
            return "redirect:adminLogin.do";
        }
    }


    //登出
    @RequestMapping("exitAdmin.do")
    public String eixt(HttpSession session) {
        session.removeAttribute("Admin");
        return "redirect: adminLogin.do";
    }

    //用户管理 &&管理员主页
    @RequestMapping("adminMain.do")
    public String userManage(HttpSession session, Model model, String currentPage, String userKey) {
        Pagination pagination = new Pagination();

        if (StringUtil.isEmpty(currentPage)) {
            currentPage = "1";
        }

        int curPage = Integer.valueOf(currentPage);
        if (curPage < 1) {
            curPage = 1;
        }

        if (StringUtil.isEmpty(userKey)) {
            userKey = "";
        }

        pagination.setCurrentPage(curPage);
        pagination.setPageSize(10);

        ArrayList<DetailUser> searchUsers = userSearchService.searchUserByKey(userKey, pagination);
        model.addAttribute("searchUsers", searchUsers);
        model.addAttribute("pagination", pagination);
        model.addAttribute("userKey", userKey);
    	model.addAttribute("curTab", "userManagementTab");
        return "admin_jsp/adminMain";
    }

    //动态管理
    @RequestMapping("dynamicManage.do")
    public String dynamicManage(Model model, String currentPage, String dynamicKey) {
        Pagination pagination = new Pagination();

        if (StringUtil.isEmpty(currentPage)) {
            currentPage = "1";
        }

        int curPage = Integer.valueOf(currentPage);
        if (curPage < 1) {
            curPage = 1;
        }

        if (StringUtil.isEmpty(dynamicKey)) {
            dynamicKey = "";
        }

        pagination.setCurrentPage(curPage);
        pagination.setPageSize(10);

        ArrayList<Dynamic> dynamics = adminService.getDynamicList(dynamicKey, pagination);
        model.addAttribute("DynamicList", dynamics);
        model.addAttribute("dynamicKey", dynamicKey);
    	model.addAttribute("curTab", "dynamicManagementTab");
    	model.addAttribute("pagination", pagination);
        return "admin_jsp/adminDynamic";
    }

    //照片管理
    @RequestMapping("photoManage.do")
    public String photoManage(HttpSession session, Model model, String currentPage) {
        Pagination pagination = new Pagination();

        if (StringUtil.isEmpty(currentPage)) {
            currentPage = "1";
        }

        int curPage = Integer.valueOf(currentPage);
        if (curPage < 1) {
            curPage = 1;
        }

        pagination.setCurrentPage(curPage);
        pagination.setPageSize(16);


        ArrayList<Picture> userAlbum = userAlbumService.queryAllAlbum(pagination);
        model.addAttribute("userAlbum", userAlbum);
    	model.addAttribute("curTab", "photoManagementTab");
    	model.addAttribute("pagination", pagination);
        return "admin_jsp/adminPhoto";
    }

    //通知发布
    @RequestMapping("noticePublish.do")
    public String noticePublish(HttpSession session, Model model) {
    	model.addAttribute("curTab", "noticePublishTab");
        return "admin_jsp/adminPublish";
    }

    @RequestMapping("pushNotice.do")
    @ResponseBody
    public boolean pushNotice(Notice notice) {
        boolean flag = adminService.pushNotice(notice);
        return flag;
    }

    //通知管理
    @RequestMapping("noticeManage.do")
    public String noticeManage(Model model, String currentPage, String noticeKey) {

        Pagination pagination = new Pagination();

        if (StringUtil.isEmpty(currentPage)) {
            currentPage = "1";
        }

        int curPage = Integer.valueOf(currentPage);
        if (curPage < 1) {
            curPage = 1;
        }

        if (StringUtil.isEmpty(noticeKey)) {
            noticeKey = "";
        }

        pagination.setCurrentPage(curPage);
        pagination.setPageSize(10);


        ArrayList<Notice> noticeList = compusInfoService.queryNotice(noticeKey, pagination);
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("curTab", "noticeManagementTab");
        model.addAttribute("pagination", pagination);
        model.addAttribute("noticeKey", noticeKey);
        return "admin_jsp/adminNotice";
    }

    //通知管理
    @RequestMapping("deleteNotice.do")
    @ResponseBody
    public boolean deleteNotice(Model model, int noticeId) {
        boolean flag = adminService.deleteNoticeById(noticeId);
        return flag;
    }

    //重置权限
    @RequestMapping("resetFunc.do")
    @ResponseBody
    public boolean resetFunc(String funcIds, int userId) {
        String[] funcIdArr = funcIds.split(",");
        int[] newFuncIds = new int[funcIdArr.length];
        for (int i = 0; i < funcIdArr.length; i++) {
            if (!StringUtil.isEmpty(funcIdArr[i])) {
                newFuncIds[i] = Integer.valueOf(funcIdArr[i]);
            }
        }

        boolean flag = true;
        flag = adminService.resetFunc(newFuncIds, userId);
        return flag;
    }

}