package com.bd.service.imply;

import java.util.List;

import com.bd.dao.BlogDao;
import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;
import com.bd.service.BlogService;

public class BlogServiceImply implements BlogService {
    BlogDao blogDao; // Ðè×¢Èë


	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}


	@Override
	public List<BlogClassifyEntity> getBlogClassify() {
		return blogDao.getBlogClassify();
	}

	@Override
	public List<BlogArticleEntity> getSelectBlogArticles(BlogClassifyEntity bc) {

		if (bc ==null ||bc.getName() == null)
			return blogDao.getAllArticles();
		else
			return blogDao.getSelectArticle(bc);
	}

	@Override
	public BlogArticleEntity getArticle(BlogArticleEntity ba) {
		return blogDao.getArticle(ba);
	}

}
