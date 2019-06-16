package com.xiaoquan.compus.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.xiaoquan.compus.entity.Picture;

@Repository
public interface UserAlbumMapper {
    public int getPictureCountById(int userId) throws Exception;
    public ArrayList<Picture> findPicturesById(int userId, int offset, int pageSize) throws Exception;
    public int deletePictureById(int pictureId) throws Exception;
    public int addPicture(Picture picture) throws Exception;
    public int getAllPictureCount() throws Exception;
    public ArrayList<Picture> findAllPictures(int offset, int pageSize) throws Exception;
}
