package com.bd.dao.imply;

import com.bd.dao.ResourceDao;
import com.bd.entity.ResourceEntity;
import com.bd.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;

public class ResourceDaoImply implements ResourceDao {

    private SessionFactory sessionFactory;

    @Override
    public boolean addResurce(UserEntity user, ResourceEntity resource) {
        Session session = sessionFactory.getCurrentSession();
        user = session.load(UserEntity.class, user.getId());
        resource.setReleaseTime(new Date(new java.util.Date().getTime()));
        user.getResourceMng().getResources().add(resource);
        try {
            session.update(user.getResourceMng());
        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        }
        return true;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
