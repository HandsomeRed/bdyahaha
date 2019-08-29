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
    public void addData() {

        session.getTransaction().begin();
        BlogMngEntity bmng = session.load(BlogMngEntity.class, 21);
        BlogArticleEntity article = new BlogArticleEntity();
        article.setBlogMng(bmng);
        try {
            session.saveOrUpdate(article);
            session.getTransaction().commit();
            System.out.println("success");
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("fail");
        }


    }


}
