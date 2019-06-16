package com.xiaoquan.compus.serviceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.entity.Picture;
import com.xiaoquan.compus.exception.DBException;
import com.xiaoquan.compus.mapper.UserAlbumMapper;
import com.xiaoquan.compus.service.UserAlbumService;
@Service("userAlbumService")
public class UserAlbumServiceImp implements UserAlbumService {
    @Autowired
    private UserAlbumMapper userAlbumMapper;

    @Override
    public ArrayList<Picture> queryUserAlbum(int userId, Pagination pagination) {
        try {
            int totalCount = userAlbumMapper.getPictureCountById(userId);
            pagination.setTotalCount(totalCount);
            return userAlbumMapper.findPicturesById(userId, pagination.getOffset(), pagination.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public boolean deletePictureById(int pictureId) {
        try {
            int resultId = userAlbumMapper.deletePictureById(pictureId);
            return resultId > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
    }

    @Override
    public boolean deletePictures(int[] pictureIds) {
        boolean flag = true;
        try {
            for (int pictureId : pictureIds) {
                userAlbumMapper.deletePictureById(pictureId);
            }
            return flag;
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
            throw new DBException();
        }
    }

	@Override
	public boolean uploadPhoto(Picture picture) {
        boolean flag = true;
        try {
            userAlbumMapper.addPicture(picture);
            return flag;
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
            throw new DBException();
        }
	}

	@Override
	public ArrayList<Picture> queryAllAlbum(Pagination pagination) {
        try {
            int totalCount = userAlbumMapper.getAllPictureCount();
            pagination.setTotalCount(totalCount);
            return userAlbumMapper.findAllPictures(pagination.getOffset(), pagination.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        }
	}

}
