package com.bd.service.imply;

import java.util.List;

import com.bd.dao.BlogDao;
import com.bd.entity.BlogArticleEntity;
import com.bd.service.BlogService;

public class BlogServiceImply implements BlogService {
    BlogDao blogDao; // Ðè×¢Èë


	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}


	@Override
	public List<BlogArticleEntity> getAllBlogArticle() {
		return blogDao.getAllBlogActicle();
	}

}
