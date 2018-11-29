package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.clasess.Property;

import java.util.List;

public class PropertyDaoImpl implements Dao<Property> {
    private static final Logger logger = LoggerFactory.getLogger(project.dao.PropertyDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Property user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        logger.info("Property successfully saved. Property details: " + user);
    }

    @Override
    public void update(Property user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("Property successfully update. Property details: " + user);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        Property user = (Property) session.get(Property.class, new Integer(id));

        if(user!=null){
            logger.info("Property successfully removed. Property details: " + user);
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();
        Property user = (Property) session.get(Property.class, login);

        if(user!=null){
            logger.info("Property exist: ");
            session.close();
            return false;
        }
        else{
            session.close();
            return true;
        }

    }


    @Override
    public Property getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (Property) session.get(Property.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<Property> list() {
        Session session = sessionFactory.openSession();
        List<Property> userList = session.createQuery("from Property").list();

        for(Property user: userList){
            System.out.println("City list: " + user);
        }
        session.close();
        return userList;
    }

    @Override
    public Property getByLoginP(String login) {
        return null;
    }
}