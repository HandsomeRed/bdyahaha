package com.bd.dao.imply;

import com.bd.dao.WriteBlogDao;
import com.bd.entity.BlogArticleEntity;
import com.bd.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;


public class WriteBlogDaoImply implements WriteBlogDao{

    private SessionFactory sessionFactory;

    @Override
    public boolean addArticle(UserEntity user, BlogArticleEntity blogArticle) {
        Session session = sessionFactory.getCurrentSession();
        blogArticle.setBlogMng(user.getBlogMng());
        blogArticle.setReleaseTime(new Date(new java.util.Date().getTime()));
        try {
            session.saveOrUpdate(blogArticle);
            return true;
        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        }
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
