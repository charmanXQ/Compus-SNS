package com.xiaoquan.compus.service;

import java.util.ArrayList;

import com.xiaoquan.compus.entity.Pagination;
import com.xiaoquan.compus.entity.Picture;

public interface UserAlbumService {
    public ArrayList<Picture> queryUserAlbum(int userId, Pagination pagination);
    public boolean deletePictureById(int pictureId);
    public boolean deletePictures(int[] pictureIds);
    public boolean uploadPhoto(Picture picture);
    public ArrayList<Picture> queryAllAlbum(Pagination pagination);
}
