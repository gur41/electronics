package project.dao.note;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.OrderUserElectronic;

import java.util.ArrayList;
import java.util.List;

public class OrderUserElectronicDaoImpl implements Dao<OrderUserElectronic> {
    private static final Logger logger = LoggerFactory.getLogger(OrderUserElectronicDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(OrderUserElectronic orderOrderUserElectronicElectronic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orderOrderUserElectronicElectronic);
        session.getTransaction().commit();
        session.close();
        logger.info("OrderUserElectronic successfully saved. OrderUserElectronic details: " + orderOrderUserElectronicElectronic);
    }

    @Override
    public void update(OrderUserElectronic orderOrderUserElectronicElectronic) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(orderOrderUserElectronicElectronic);
        logger.info("OrderUserElectronic successfully update. OrderUserElectronic details: " + orderOrderUserElectronicElectronic);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        OrderUserElectronic orderOrderUserElectronicElectronic = (OrderUserElectronic) session.get(OrderUserElectronic.class, new Integer(id));

        if(orderOrderUserElectronicElectronic!=null){
            logger.info("OrderUserElectronic successfully removed. OrderUserElectronic details: " + orderOrderUserElectronicElectronic);
            session.beginTransaction();
            session.delete(orderOrderUserElectronicElectronic);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from OrderUserElectronic where login = '"+login+"'").iterate().hasNext()){
            logger.info("OrderUserElectronic exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public OrderUserElectronic getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (OrderUserElectronic) session.get(OrderUserElectronic.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<OrderUserElectronic> list() {
        Session session = sessionFactory.openSession();
        List<OrderUserElectronic> orderOrderUserElectronicElectronicList = session.createQuery("from OrderUserElectronic").list();

        for(OrderUserElectronic orderOrderUserElectronicElectronic: orderOrderUserElectronicElectronicList){
            System.out.println("City list: " + orderOrderUserElectronicElectronic);
        }
        session.close();
        return orderOrderUserElectronicElectronicList;
    }

    @Override
    public OrderUserElectronic getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<OrderUserElectronic> points1 = new ArrayList<OrderUserElectronic>();
        if(session.createQuery("from OrderUserElectronic where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from OrderUserElectronic where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

