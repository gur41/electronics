package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.RamForNotebook;

import java.util.ArrayList;
import java.util.List;

public class RamForNotebookDaoImpl implements Dao<RamForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(RamForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(RamForNotebook ramForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(ramForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("RamForNotebook successfully saved. RamForNotebook details: " + ramForNotebook);
    }

    @Override
    public void update(RamForNotebook ramForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ramForNotebook);
        logger.info("RamForNotebook successfully update. RamForNotebook details: " + ramForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        RamForNotebook ramForNotebook = (RamForNotebook) session.get(RamForNotebook.class, new Integer(id));

        if(ramForNotebook!=null){
            logger.info("RamForNotebook successfully removed. RamForNotebook details: " + ramForNotebook);
            session.beginTransaction();
            session.delete(ramForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from RamForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("RamForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public RamForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (RamForNotebook) session.get(RamForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<RamForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<RamForNotebook> ramForNotebookList = session.createQuery("from RamForNotebook").list();

        for(RamForNotebook ramForNotebook: ramForNotebookList){
            System.out.println("City list: " + ramForNotebook);
        }
        session.close();
        return ramForNotebookList;
    }

    @Override
    public RamForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<RamForNotebook> points1 = new ArrayList<RamForNotebook>();
        if(session.createQuery("from RamForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from RamForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

