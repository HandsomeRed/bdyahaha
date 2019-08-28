package com.bd.dao.imply;

import java.util.ArrayList;
import java.util.List;

import com.bd.entity.BlogClassifyEntity;
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



	@Override // 查询所有博文类型 返回List<博文类型对象>
	public List<BlogClassifyEntity> getBlogClassify() {
		List<BlogClassifyEntity> baList = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(BlogClassifyEntity.class);
		baList = c.list();
		return baList;
	}

	@Override	//获取欲加载的一类文章
	public List<BlogArticleEntity> getSelectArticle(BlogClassifyEntity bc) {
		List<BlogArticleEntity> list = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BlogClassifyEntity.class);

		for (BlogClassifyEntity b : (List<BlogClassifyEntity>)criteria.list()){
			if (b.getName().equals(bc.getName())){
				list = new ArrayList<>(b.getBlogArticles());
			}
		}
		return list;
	}

	@Override
	public List<BlogArticleEntity> getAllArticles() {
		return sessionFactory.getCurrentSession().createCriteria(BlogArticleEntity.class).list();
	}

}
