package com.xiaoquan.compus.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.Notice;
import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.CompusInfoMapper;
import com.xiaoquan.compus.service.CompusInfoService;
@Service("compusInfoService")
public class CompusInfoServiceImp implements CompusInfoService {
    @Autowired
    private CompusInfoMapper compusInfoMapper;

    @Override
    public Map<String, List<Notice>> getNoticeMap() {
        try {
            Map<String, List<Notice>> noticeMap = new HashMap<String, List<Notice>>();
            List<Notice> academicList = compusInfoMapper.getNoticeListById(1);
            noticeMap.put("academicList", academicList);
            List<Notice> lifeList = compusInfoMapper.getNoticeListById(2);
            noticeMap.put("lifeList", lifeList);
            List<Notice> newsList = compusInfoMapper.getNoticeListById(3);
            noticeMap.put("newsList", newsList);
            return noticeMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

	@Override
	public ArrayList<Notice> queryNotice(String noticeKey, Pagination pagination) {
        try {
            pagination.setTotalCount(compusInfoMapper.getNoticeTotalCount());
            ArrayList<Notice> noticeList = compusInfoMapper.getNoticeList(noticeKey, pagination.getOffset(), pagination.getPageSize());
            return noticeList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
	}

}
