package com.xiaoquan.compus.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.entity.Picture;
import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.service.UserAlbumService;
import com.xiaoquan.compus.util.StringUtil;

@Controller
public class UserAlbumController {
    @Resource(name="userAlbumService")
    private UserAlbumService userAlbumService;

    //私人相册
    @RequestMapping("userAlbum.do")
    public String userAlbum(HttpSession session, Model model, String currentPage) {
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

        ArrayList<Picture> userAlbum = userAlbumService.queryUserAlbum(curUser.getId(), pagination);
        model.addAttribute("userAlbum", userAlbum);
        model.addAttribute("pagination", pagination);
        return "user_jsp/userAlbum";
    }

    //删除一张照片
    @RequestMapping("deleteOnePicture.do")
    @ResponseBody
    public boolean deleteOnePicture(int pictureId) {
        boolean flag = userAlbumService.deletePictureById(pictureId);
        return flag;
    }

    //删除多张照片
    @RequestMapping("deletePictures.do")
    @ResponseBody
    public boolean deletePictures(String deleteIds) {
        String[] pictureIdArr = deleteIds.split(",");
        int[] pictureIds = new int[pictureIdArr.length];
        for (int i = 0; i < pictureIdArr.length; i++) {
            if (!StringUtil.isEmpty(pictureIdArr[i])) {
                pictureIds[i] = Integer.valueOf(pictureIdArr[i]);
            }
        }
        boolean flag = userAlbumService.deletePictures(pictureIds);
        return flag;
    }

    //上传图片
    @RequestMapping("uploadPhoto.do")
    @ResponseBody
    public boolean uploadPhoto(HttpSession session, @RequestParam("fileList") CommonsMultipartFile userPhoto) {
        User curUser = (User)session.getAttribute("USER");
        Picture picture = new Picture();
        if (userPhoto != null) {
            String originalFileName = userPhoto.getOriginalFilename();
            picture.setName(originalFileName);
            String newFileName = new Date().getTime() + "_" + originalFileName;
            String pic_path = curUser.getId()  + "/" + newFileName;
            picture.setPicURL(pic_path);
            picture.setOwnerId(curUser.getId());
            userAlbumService.uploadPhoto(picture);

            String base_path = "G://user_photo//";
            File newfile = new File(base_path + pic_path);
            try {
                userPhoto.transferTo(newfile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
