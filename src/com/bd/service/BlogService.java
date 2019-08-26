package com.bd.service;

import java.util.List;

import com.bd.entity.BlogArticleEntity;

public interface BlogService {
	
	// 获取所有文章
	public List<BlogArticleEntity> getAllBlogArticle();
	
}
