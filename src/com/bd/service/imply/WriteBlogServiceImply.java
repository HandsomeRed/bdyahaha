package com.bd.service.imply;

import com.bd.dao.WriteBlogDao;
import com.bd.entity.BlogArticleEntity;
import com.bd.entity.UserEntity;
import com.bd.service.WriteBlogService;
import tool.Key_Value;

import java.io.*;

public class WriteBlogServiceImply implements WriteBlogService{

    private WriteBlogDao writeBlogDao;

    @Override
    public boolean addArticle(UserEntity user, BlogArticleEntity blogArticle) {
        return writeBlogDao.addArticle(user, blogArticle);
    }

    @Override
    public String savePicture(File upload, String uploadFileName) {

        File savePic = new File(upload.getPath());
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            System.out.println("*************************************");
            inputStream = new FileInputStream(upload);
            outputStream = new FileOutputStream(Key_Value.pictureUrl + Key_Value.enter + uploadFileName);

            System.out.println();
            byte[] bytes = new byte[2048];
            int len;
            while ((len = inputStream.read(bytes)) >= 0) {
                outputStream.write(bytes, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "";
    }


    public WriteBlogDao getWriteBlogDao() {
        return writeBlogDao;
    }

    public void setWriteBlogDao(WriteBlogDao writeBlogDao) {
        this.writeBlogDao = writeBlogDao;
    }
}
