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

	SessionFactory sessionFactory;// ע��Spring�����е�sessionFactoryʵ��

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override // ��ѯ���в������� ����List<�������Ͷ���>
	public List<BlogClassifyEntity> getBlogClassify() {
		List<BlogClassifyEntity> baList = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(BlogClassifyEntity.class);
		baList = c.list();
		return baList;
	}

	@Override	//��ȡ�����ص�һ������
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


	@Override // �м�¼�򷵻ؼ�¼,û�з���null;
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

		// �����һ�ν��벩�͹���ҳ��ʱ ǰ�˲���ba
		if(ba==null) {
			ba = new BlogArticleEntity();
		}
		
		//Ԥ����user����
		user = session.load(user.getClass(), user.getId());

		//��blogMng
		ba.setBlogMng(user.getBlogMng());

		// ʱ��Լ��
		if (ba.getReleaseTime() != null)
			criteria.add(Restrictions.ge("releaseTime", ba.getReleaseTime()));

		//status Լ��
		if (ba.getStatus() != null)
			criteria.add(Restrictions.eq("status", ba.getStatus()));

		//blogMngԼ��
		criteria.add(Restrictions.eq("blogMng", ba.getBlogMng()));

		//�����ڽ���
		criteria.addOrder(Order.desc("releaseTime"));
		return criteria.list();

	}

}





















