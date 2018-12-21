package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.CameraSoundForNotebook;

import java.util.ArrayList;
import java.util.List;

public class CameraSoundForNotebookDaoImpl implements Dao<CameraSoundForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(CameraSoundForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CameraSoundForNotebook cameraSoundForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cameraSoundForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("CameraSoundForNotebook successfully saved. CameraSoundForNotebook details: " + cameraSoundForNotebook);
    }

    @Override
    public void update(CameraSoundForNotebook cameraSoundForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cameraSoundForNotebook);
        logger.info("CameraSoundForNotebook successfully update. CameraSoundForNotebook details: " + cameraSoundForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        CameraSoundForNotebook cameraSoundForNotebook = (CameraSoundForNotebook) session.get(CameraSoundForNotebook.class, new Integer(id));

        if(cameraSoundForNotebook!=null){
            logger.info("CameraSoundForNotebook successfully removed. CameraSoundForNotebook details: " + cameraSoundForNotebook);
            session.beginTransaction();
            session.delete(cameraSoundForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from CameraSoundForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("CameraSoundForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public CameraSoundForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (CameraSoundForNotebook) session.get(CameraSoundForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<CameraSoundForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<CameraSoundForNotebook> cameraSoundForNotebookList = session.createQuery("from CameraSoundForNotebook").list();

        for(CameraSoundForNotebook cameraSoundForNotebook: cameraSoundForNotebookList){
            System.out.println("City list: " + cameraSoundForNotebook);
        }
        session.close();
        return cameraSoundForNotebookList;
    }

    @Override
    public CameraSoundForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<CameraSoundForNotebook> points1 = new ArrayList<CameraSoundForNotebook>();
        if(session.createQuery("from CameraSoundForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from CameraSoundForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

