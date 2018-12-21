package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.ScreenForNotebook;

import java.util.ArrayList;
import java.util.List;

public class ScreenForNotebookDaoImpl implements Dao<ScreenForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(ScreenForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(ScreenForNotebook screenForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(screenForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("ScreenForNotebook successfully saved. ScreenForNotebook details: " + screenForNotebook);
    }

    @Override
    public void update(ScreenForNotebook screenForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(screenForNotebook);
        logger.info("ScreenForNotebook successfully update. ScreenForNotebook details: " + screenForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        ScreenForNotebook screenForNotebook = (ScreenForNotebook) session.get(ScreenForNotebook.class, new Integer(id));

        if(screenForNotebook!=null){
            logger.info("ScreenForNotebook successfully removed. ScreenForNotebook details: " + screenForNotebook);
            session.beginTransaction();
            session.delete(screenForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from ScreenForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("ScreenForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public ScreenForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (ScreenForNotebook) session.get(ScreenForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<ScreenForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<ScreenForNotebook> screenForNotebookList = session.createQuery("from ScreenForNotebook").list();

        for(ScreenForNotebook screenForNotebook: screenForNotebookList){
            System.out.println("City list: " + screenForNotebook);
        }
        session.close();
        return screenForNotebookList;
    }

    @Override
    public ScreenForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<ScreenForNotebook> points1 = new ArrayList<ScreenForNotebook>();
        if(session.createQuery("from ScreenForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from ScreenForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

