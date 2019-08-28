package com.bd.dao.imply;

import java.util.List;

import com.bd.entity.BlogMngEntity;
import com.bd.entity.ResourceMngEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.bd.dao.UserDao;
import com.bd.entity.UserEntity;

public class UserDaoImply implements UserDao{

	SessionFactory sessionFactory; // 需注入
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 查找用户
	@Override
	public List<UserEntity> search(UserEntity cond) {
		// TODO Auto-generated method stub
		List<UserEntity> ueList = null;
		Session session = sessionFactory.getCurrentSession(); // 创建hibernate session对象
		Criteria criteria = session.createCriteria(UserEntity.class);
		Example example = Example.create(cond); // 创建实例对象
		criteria.add(example);
		ueList = criteria.list();
		return ueList;
	}

	
	// 添加用户 同时添加其blogMng , resourceMng.
	// 对于blogMng , resourceMng : default lv  rank = 1 -1.
	// 对于resourceMng : default upload = 5
	@Override
	public int addUser(UserEntity cond) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.getTransaction();

		cond.setResourceMng(new ResourceMngEntity());
		cond.getResourceMng().setUser(cond);

		cond.setBlogMng(new BlogMngEntity());
		cond.getBlogMng().setUser(cond);
		cond.getBlogMng().setTitle(cond.getAccount() + " 的博客");


		int result =  (Integer) session.save(cond); // 添加至数据库 .save()返回的是主键
		System.out.println("[UserDaoImply - addUser]结束:" + result);
		return result;
	}

	//查询用户是否可用
	public boolean checkUser(UserEntity cond) {
		boolean result = false;
		List<UserEntity> ueList = null;
		Session session = sessionFactory.getCurrentSession(); // 创建hibernate session对象
		Criteria criteria = session.createCriteria(UserEntity.class);
		Example example = Example.create(cond); // 创建实例对象
		criteria.add(example);
		System.out.println(ueList==null);
		ueList = criteria.list();
		if(ueList.isEmpty()) {
			result  = true;
		}
		return result;
	}
	
}
