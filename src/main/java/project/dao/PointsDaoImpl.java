package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import last.Points;

import java.util.ArrayList;
import java.util.List;

public class PointsDaoImpl implements Dao<Points> {

    private static final Logger logger = LoggerFactory.getLogger(project.dao.PointsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Points points) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(points);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Points points) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(points);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Points getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (Points) session.get(Points.class, new Integer(id));
        } finally {
            session.close();
        }
    }

    @Override
    public boolean getByLogin(String name_of_point) {
        Session session = sessionFactory.openSession();

        if(session.createQuery("from Points where name_of_point = '"+name_of_point+"'").iterate().hasNext()){
            logger.info("Point exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }
    }

    @Override
    public Points getByLoginP(String name_of_point) {
        Session session = sessionFactory.openSession();
        List<Points> points1 = new ArrayList<Points>();
        if(session.createQuery("from Points where name_of_point = '"+name_of_point+"'").iterate().hasNext())
            points1 = session.createQuery("from Points where name_of_point = '"+name_of_point+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }

    @Override
    public List<Points> list() {
        return null;
    }
}
