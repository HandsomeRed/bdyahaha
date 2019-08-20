package com.bd.dao.imply;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.bd.dao.UserDao;
import com.bd.entity.UserEntity;

public class UserDaoImply implements UserDao{

	SessionFactory sessionFactory; // ��ע��
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// �����û�
	@Override
	public List<UserEntity> search(UserEntity cond) {
		// TODO Auto-generated method stub
		List<UserEntity> ueList = null;
		Session session = sessionFactory.getCurrentSession(); // ����hibernate session����
		Criteria criteria = session.createCriteria(UserEntity.class);
		Example example = Example.create(cond); // ����ʵ������
		criteria.add(example);
		ueList = criteria.list();
		return ueList;
	}

	
	// ����û�
	@Override
	public int addUser(UserEntity cond) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.getTransaction();
		int result =  (Integer) session.save(cond); // ��������ݿ� .save()���ص�������
		System.out.println("[UserDaoImply - addUser]����:" + result);
		return result;
	}
	
}
