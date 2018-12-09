package project.dao;

import last.Maps;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MapsDaoImpl implements Dao<Maps> {

    private static final Logger logger = LoggerFactory.getLogger(MapsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Maps maps) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(maps);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Maps maps) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(maps);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Maps getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (Maps) session.get(Maps.class, new Integer(id));
        } finally {
            session.close();
        }
    }

    @Override
    public boolean getByLogin(String name_of_point) {
        Session session = sessionFactory.openSession();

        if(session.createQuery("from Maps where name_of_point = '"+name_of_point+"'").iterate().hasNext()){
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
    public Maps getByLoginP(String name_of_point) {
        Session session = sessionFactory.openSession();

        Maps maps = null;
        maps = (Maps) session.createQuery("from Maps where name_of_point = '"+name_of_point+"'").iterate().next();
            logger.info("Point exist: ");
            session.close();
            return maps;

    }

    @Override
    public List<Maps> list() {
        Session session = sessionFactory.openSession();

        List<Maps> userList = session.createQuery("from Maps").list();

        session.close();
        return userList;
    }


}
