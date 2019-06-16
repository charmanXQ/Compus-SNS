package com.xiaoquan.compus.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoquan.compus.entity.Notice;
import com.xiaoquan.compus.service.CompusInfoService;

@Controller
public class CompusInfoController {
    @Resource(name="compusInfoService")
    private CompusInfoService compusInfoService;
    //进入校园资讯
    @RequestMapping("compusInfo.do")
    public String compusInfo(Model model) {
        Map<String,List<Notice>> noticeResult = compusInfoService.getNoticeMap();
        Set<String> types = noticeResult.keySet();
        for (String type : types) {
            model.addAttribute(type, noticeResult.get(type));
        }
        return "user_jsp/compusInfo";
    }
}
