package com.bd.dao;

import java.util.List;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;

public interface BlogDao {
	
	// 获取所有文章类型
	public List<BlogClassifyEntity> getBlogClassify();
	//获取欲加载的一类文章
	public List<BlogArticleEntity> getSelectArticle(BlogClassifyEntity bc);
	
}
