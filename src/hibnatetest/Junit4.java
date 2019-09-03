package hibnatetest;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogMngEntity;
import com.bd.entity.ResourceMngEntity;
import com.bd.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

        session.getTransaction().begin();
        UserEntity user = new UserEntity();
        user.setBlogMng(new BlogMngEntity());
        session.save(user);
        session.getTransaction().commit();

    }


}
