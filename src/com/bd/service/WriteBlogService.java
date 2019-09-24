package com.bd.service;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.UserEntity;

import java.io.File;

public interface WriteBlogService {

    public boolean addArticle(UserEntity user, BlogArticleEntity blogArticle);

    String savePicture(File upload, String uploadFileName);
}
