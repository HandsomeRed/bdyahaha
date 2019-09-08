package com.bd.dao.imply;

import com.bd.dao.ResourceDao;
import com.bd.entity.ResourceEntity;
import com.bd.entity.ResourceMngEntity;
import com.bd.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.List;

public class ResourceDaoImply implements ResourceDao {

    private SessionFactory sessionFactory;

    @Override
    public boolean addResource(UserEntity user, ResourceEntity resource) {
        Session session = sessionFactory.getCurrentSession();
        user = session.load(UserEntity.class, user.getId());
        resource.setReleaseTime(new Date(new java.util.Date().getTime()));
        resource.setResourceMng(user.getResourceMng());
        resource.setType("原创");
        resource.setStatus("公开");
        try {
            session.saveOrUpdate(resource);
        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ResourceEntity> getResources(UserEntity user, ResourceEntity resource) {
        
    	if(resource == null) resource = new ResourceEntity();
    	
    	List list = sessionFactory
                .getCurrentSession()
                .createCriteria(ResourceEntity.class)
                .add(Example.create(resource))
                .addOrder(Order.desc("releaseTime"))
                .createCriteria("resourceMng")
                .add(Restrictions.eq("id", user.getBlogMng().getId()))
                .list();
        return list;
    }

    @Override
    public ResourceEntity getResource(ResourceEntity re) {
    	if(re == null) re = new ResourceEntity();
        return sessionFactory
                .getCurrentSession()
                .load(ResourceEntity.class, re.getId());
    }

    @Override
    public List<ResourceEntity> getResourceList(ResourceEntity resource) {
    	
    	if(resource == null) resource = new ResourceEntity();
    	
        return sessionFactory.getCurrentSession().createCriteria(ResourceEntity.class).add(Example.create(resource)).addOrder(Order.desc("releaseTime")).list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
