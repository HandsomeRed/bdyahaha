package com.bd.dao.imply;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bd.dao.BlogDao;
import com.bd.entity.BlogArticleEntity;

public class BlogDaoImply implements BlogDao {

	SessionFactory sessionFactory;// 注入Spring容器中的sessionFactory实例
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override // 查询所有博文 返回List<博文对象>
	public List<BlogArticleEntity> getAllBlogActicle() {
		List<BlogArticleEntity> baList = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(BlogArticleEntity.class);
		baList = c.list();
		return baList;
	}

}
