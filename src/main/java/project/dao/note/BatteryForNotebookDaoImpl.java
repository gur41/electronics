package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.BatteryForNotebook;

import java.util.ArrayList;
import java.util.List;

public class BatteryForNotebookDaoImpl implements Dao<BatteryForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(BatteryForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(BatteryForNotebook batteryForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(batteryForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("BatteryForNotebook successfully saved. BatteryForNotebook details: " + batteryForNotebook);
    }

    @Override
    public void update(BatteryForNotebook batteryForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(batteryForNotebook);
        logger.info("BatteryForNotebook successfully update. BatteryForNotebook details: " + batteryForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        BatteryForNotebook batteryForNotebook = (BatteryForNotebook) session.get(BatteryForNotebook.class, new Integer(id));

        if(batteryForNotebook!=null){
            logger.info("BatteryForNotebook successfully removed. BatteryForNotebook details: " + batteryForNotebook);
            session.beginTransaction();
            session.delete(batteryForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from BatteryForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("BatteryForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public BatteryForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (BatteryForNotebook) session.get(BatteryForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<BatteryForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<BatteryForNotebook> batteryForNotebookList = session.createQuery("from BatteryForNotebook").list();

        for(BatteryForNotebook batteryForNotebook: batteryForNotebookList){
            System.out.println("City list: " + batteryForNotebook);
        }
        session.close();
        return batteryForNotebookList;
    }

    @Override
    public BatteryForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<BatteryForNotebook> points1 = new ArrayList<BatteryForNotebook>();
        if(session.createQuery("from BatteryForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from BatteryForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

