package project.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.User;

import java.util.List;

public class UserDaoImpl implements Dao<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        logger.info("User successfully saved. User details: " + user);
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully update. User details: " + user);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, new Integer(id));

        if(user!=null){
            logger.info("User successfully removed. User details: " + user);
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from User where login = '"+login+"'").iterate().hasNext()){
            logger.info("User exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (User) session.get(User.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();

        for(User user: userList){
            System.out.println("City list: " + user);
        }
        session.close();
        return userList;
    }

    @Override
    public User getByLoginP(String login) {
        return null;
    }
}

