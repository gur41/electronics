package project.dao;


import last.OrderUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OrderUserDaoImpl implements Dao<OrderUser> {
    private static final Logger logger = LoggerFactory.getLogger(OrderUserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(OrderUser orderUser) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orderUser);
        session.getTransaction().commit();
        session.close();
        logger.info("OrderUser successfully saved. OrderUser details: " + orderUser);
    }

    @Override
    public void update(OrderUser orderUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(orderUser);
        logger.info("OrderUser successfully update. OrderUser details: " + orderUser);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        OrderUser orderUser = (OrderUser) session.get(OrderUser.class, new Integer(id));

        if(orderUser!=null){
            logger.info("OrderUser successfully removed. OrderUser details: " + orderUser);
            session.beginTransaction();
            session.delete(orderUser);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from OrderUser where login = '"+login+"'").iterate().hasNext()){
            logger.info("OrderUser exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public OrderUser getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (OrderUser) session.get(OrderUser.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<OrderUser> list() {
        Session session = sessionFactory.openSession();
        List<OrderUser> orderUserList = session.createQuery("from OrderUser").list();

        for(OrderUser orderUser: orderUserList){
            System.out.println("City list: " + orderUser);
        }
        session.close();
        return orderUserList;
    }

    @Override
    public OrderUser getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<OrderUser> points1 = new ArrayList<OrderUser>();
        if(session.createQuery("from OrderUser where id_user_order = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from OrderUser where id_user_order = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

