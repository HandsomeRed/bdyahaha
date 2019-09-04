package com.bd.dao.imply;

import java.util.ArrayList;
import java.util.List;

import com.bd.entity.BlogClassifyEntity;
import com.bd.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bd.dao.BlogDao;
import com.bd.entity.BlogArticleEntity;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
		criteria.add(Example.create(bc));
		bc = (BlogClassifyEntity) criteria.uniqueResult();
		return new ArrayList<>(bc.getBlogArticles());
	}

	@Override
	public List<BlogArticleEntity> getAllArticles() {
		return sessionFactory.getCurrentSession().createCriteria(BlogArticleEntity.class).list();
	}


	@Override // 有记录则返回记录,没有返回null;
	public BlogArticleEntity getArticle(BlogArticleEntity ba) {
		Session session = sessionFactory.getCurrentSession();
		BlogArticleEntity ret = null;

		try {
			BlogArticleEntity article = session.load(BlogArticleEntity.class, ba.getId());
			article.setReadNum(article.getReadNum() + 1);
			session.update(article);
			return article;
		} catch (HibernateException he) {
			return null;
		}

	}

	@Override
	public List<BlogArticleEntity> getArticles(UserEntity user, BlogArticleEntity ba) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BlogArticleEntity.class);

		// 处理第一次进入博客管理页面时 前端不传ba
		if(ba==null) {
			ba = new BlogArticleEntity();
		}
		
		//预加载user对象
		user = session.load(user.getClass(), user.getId());

		//绑定blogMng
		ba.setBlogMng(user.getBlogMng());

		// 时间约束
		if (ba.getReleaseTime() != null)
			criteria.add(Restrictions.ge("releaseTime", ba.getReleaseTime()));

		//status 约束
		if (ba.getStatus() != null)
			criteria.add(Restrictions.eq("status", ba.getStatus()));

		//blogMng约束
		criteria.add(Restrictions.eq("blogMng", ba.getBlogMng()));

		//按日期降序
		criteria.addOrder(Order.desc("releaseTime"));
		return criteria.list();

	}

}





















