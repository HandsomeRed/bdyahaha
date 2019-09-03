package hibnatetest;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogMngEntity;
import com.bd.entity.ResourceMngEntity;
import com.bd.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Scanner;

public class Junit4 {

    private Session session = null;

    @Before
    public void after() {
        if (session == null) session = HibernateSession.getSession();
    }


    @After
    public void before() {
        if (session != null) {
            if (session.isConnected()) {
//                session.getTransaction().commit();
                session.close();
            }
        }
    }


    @Test
    public void test() {
        UserEntity user = new UserEntity();
        user.setId(6);
        user = session.load(UserEntity.class, user.getId());
        System.out.println(user.getAccount());

    }


}
