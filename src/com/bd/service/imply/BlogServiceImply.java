package com.bd.service.imply;

import java.util.List;

import com.bd.dao.BlogDao;
import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;
import com.bd.entity.UserEntity;
import com.bd.service.BlogService;

public class BlogServiceImply implements BlogService {
    BlogDao blogDao; // ��ע��


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

    @Override
	public List<BlogArticleEntity> getMyArticles(UserEntity user, BlogArticleEntity ba) {
		return blogDao.getArticles(user, ba);
    }

	@Override
	public List<BlogArticleEntity> getBlogMng(UserEntity user) {

		BlogArticleEntity example = new BlogArticleEntity();
		example.setStatus("public");
		return blogDao.getArticles(user, example);

	}

}
