package com.bd.dao;

import java.util.List;

import com.bd.entity.BlogArticleEntity;

public interface BlogDao {
	
	// 获取所有文章
	public List<BlogArticleEntity> getAllBlogActicle();
	
}
