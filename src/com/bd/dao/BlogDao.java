package com.bd.dao;

import java.util.List;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;

public interface BlogDao {
	
	// ��ȡ������������
	public List<BlogClassifyEntity> getBlogClassify();
	//��ȡ�����ص�һ������
	public List<BlogArticleEntity> getSelectArticle(BlogClassifyEntity bc);
	
}
