package com.xiaoquan.compus.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xiaoquan.compus.entity.User;
import com.xiaoquan.compus.exception.ServiceException;
import com.xiaoquan.compus.service.UserService;
import com.xiaoquan.compus.util.MD5Util;
import com.xiaoquan.compus.util.VerifyCodeUtil;

@Controller
public class UserController {
    @Resource(name="userService")
    private UserService userService;
    //��Ӧ��¼����
    @RequestMapping("userLogin.do")
    public String userLogin() {
        return "user_jsp/userLogin";
    }
    //����ǳ��Ƿ��Ѵ���
    @RequestMapping("checkNickName.do")
    @ResponseBody
    public boolean checkNickName(String inputNickName) {
        int id = userService.checkNickName(inputNickName);
        return id < 0 ? true : false;
    }
    //��������Ƿ��Ѵ���
    @RequestMapping("checkEmail.do")
    @ResponseBody
    public boolean checkEmail(String inputEmail) {
        int id = userService.checkEmail(inputEmail);
        return id < 0 ? true : false;
    }
    //�����֤��
    @RequestMapping("checkCode.do")
    @ResponseBody
    public boolean checkCode(HttpSession session, String inputCode) {
        String relCode = (String)session.getAttribute("code");
        return relCode.equalsIgnoreCase(inputCode) ? true : false;
    }
    //�õ���֤��
    @RequestMapping("getVerifyCode.do")
    public void getVerifyCode(HttpSession session, HttpServletResponse response) {
        Map<String, Object> map = VerifyCodeUtil.getImage();
        session.setAttribute("code", map.get("code"));
        response.setContentType("image/jpeg");
        ServletOutputStream sos = null;
        try {
            sos = response.getOutputStream();
            ImageIO.write((BufferedImage)map.get("image"), "jpeg", sos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sos != null) {
                    sos.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    //����û���¼
    @RequestMapping("checkUser.do")
    public String userLogin(RedirectAttributes redirectAttributes, String email, String password, HttpSession session) {
        try {
            String md5Pwd = MD5Util.md5(password);
            User user = userService.checkUser(email, md5Pwd);
            session.setAttribute("USER", user);
            return "redirect:userMain.do#userMain";
        } catch (ServiceException se) {
            redirectAttributes.addFlashAttribute("ErrorMessage", "[" + se.getErrorCode() + "]" + se.getErrorMessage());
            return "redirect:userLogin.do";
        }
    }

    //��Ӧ�û�ע��
    @RequestMapping("userRegister.do")
    public String userRegister(User user, RedirectAttributes redirectAttributes) {
        user.setPassword(MD5Util.md5(user.getPassword()));
        try {
            userService.addUser(user);
            redirectAttributes.addFlashAttribute("ErrorMessage", "ע��ɹ������Ͽ�ȥ��¼�ɣ�");
            return "redirect:userLogin.do";
        } catch (ServiceException se) {
            redirectAttributes.addFlashAttribute("ErrorMessage", "[" + se.getErrorCode() + "]" + se.getErrorMessage());
            return "redirect:userLogin.do";
        }
    }

    //����ͷ��
    @RequestMapping(value = "changeLogo.do",method = RequestMethod.POST)
    @ResponseBody
    public boolean changeLogo(HttpSession session, @RequestParam("userNewLogo") CommonsMultipartFile userNewLogo) {
        boolean flag = false;
        User user = (User)session.getAttribute("USER");
        int userId = user.getId();

        if (userNewLogo != null) {
            String newLogoUrl = "user_images/"+ userId +"/myLogo.jpg";
            user.setLogoUrl(newLogoUrl);
            userService.changeUserLogoURL(userId, newLogoUrl);
            String base_path = "G://user_photo//" + userId + "/myLogo.jpg";
            File newfile = new File(base_path);
            try {
                userNewLogo.transferTo(newfile);
                flag = true;
            } catch (IllegalStateException e) {
                e.printStackTrace();
                flag = false;
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

    //�ǳ�
    @RequestMapping("exit.do")
    public String eixt(HttpSession session) {
        session.removeAttribute("USER");
        return "redirect: userLogin.do";
    }

}
