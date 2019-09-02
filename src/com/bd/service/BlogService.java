package com.bd.service;

import java.util.List;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;

public interface BlogService {
	
	// 获取所有文章类型
	List<BlogClassifyEntity> getBlogClassify();
	//获取欲加载的一类文章
	List<BlogArticleEntity> getSelectBlogArticles(BlogClassifyEntity bc);

	BlogArticleEntity getArticle(BlogArticleEntity ba);

    List<BlogArticleEntity> getMyArticles(BlogArticleEntity ba);
}
