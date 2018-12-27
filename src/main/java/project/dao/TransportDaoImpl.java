package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.last.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportDaoImpl implements Dao<Transport>, DaoTransport<Transport> {

    private static final Logger logger = LoggerFactory.getLogger(TransportDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Transport transport) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(transport);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Transport transport) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(transport);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Transport getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (Transport) session.get(Transport.class, new Integer(id));
        } finally {
            session.close();
        }
    }

    @Override
    public boolean getByLogin(String name_of_point) {
        Session session = sessionFactory.openSession();

        if (session.createQuery("from Transport where name_of_point = '" + name_of_point + "'").iterate().hasNext()) {
            logger.info("Point exist: ");
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    @Override
    public List<Transport> list() {
        Session session = sessionFactory.openSession();
        List<Transport> userList = session.createQuery("from Transport").list();

        session.close();
        return userList;
    }

    @Override
    public Transport getByLoginP(String login) {
        return null;
    }

    @Override
    public Transport getByTransport(Transport transport) {
        Session session = sessionFactory.openSession();
        List <Transport> transport1 = new ArrayList<Transport>();
        if (session.createQuery("from Transport where transport_name = '" + transport.getTransportName() + "' and speed = '" + transport.getSpeed() + "' and coefficient = '" + transport.getCoefficient() + "' and max_weight = '" + transport.getMaxWeight() + "'").iterate().hasNext()) {
            transport1 = session.createQuery("from Transport where transport_name = '" + transport.getTransportName() + "' and speed = '" + transport.getSpeed() + "' and coefficient = '" + transport.getCoefficient() + "' and max_weight = '" + transport.getMaxWeight() + "'").list();
            logger.info("Point exist: ");
            session.close();
            System.out.println("ID_TRANSPORT: "+transport1.get(0).getIdTransport());
            return transport1.get(0);
        } else
            return null;
    }
}
