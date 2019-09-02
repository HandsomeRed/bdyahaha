package com.bd.service;

import java.util.List;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;

public interface BlogService {
	
	// ��ȡ������������
	List<BlogClassifyEntity> getBlogClassify();
	//��ȡ�����ص�һ������
	List<BlogArticleEntity> getSelectBlogArticles(BlogClassifyEntity bc);

	BlogArticleEntity getArticle(BlogArticleEntity ba);

    List<BlogArticleEntity> getMyArticles(BlogArticleEntity ba);
}
