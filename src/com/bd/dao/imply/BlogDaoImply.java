package com.bd.dao.imply;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bd.dao.BlogDao;
import com.bd.entity.BlogArticleEntity;

public class BlogDaoImply implements BlogDao {

	SessionFactory sessionFactory;// ע��Spring�����е�sessionFactoryʵ��
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override // ��ѯ���в��� ����List<���Ķ���>
	public List<BlogArticleEntity> getAllBlogActicle() {
		List<BlogArticleEntity> baList = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(BlogArticleEntity.class);
		baList = c.list();
		return baList;
	}

}
