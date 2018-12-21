package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.FounctionsForNotebook;

import java.util.ArrayList;
import java.util.List;

public class FounctionsForNotebookDaoImpl implements Dao<FounctionsForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(FounctionsForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(FounctionsForNotebook founctionsForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(founctionsForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("FounctionsForNotebook successfully saved. FounctionsForNotebook details: " + founctionsForNotebook);
    }

    @Override
    public void update(FounctionsForNotebook founctionsForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(founctionsForNotebook);
        logger.info("FounctionsForNotebook successfully update. FounctionsForNotebook details: " + founctionsForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        FounctionsForNotebook founctionsForNotebook = (FounctionsForNotebook) session.get(FounctionsForNotebook.class, new Integer(id));

        if(founctionsForNotebook!=null){
            logger.info("FounctionsForNotebook successfully removed. FounctionsForNotebook details: " + founctionsForNotebook);
            session.beginTransaction();
            session.delete(founctionsForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from FounctionsForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("FounctionsForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public FounctionsForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (FounctionsForNotebook) session.get(FounctionsForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<FounctionsForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<FounctionsForNotebook> founctionsForNotebookList = session.createQuery("from FounctionsForNotebook").list();

        for(FounctionsForNotebook founctionsForNotebook: founctionsForNotebookList){
            System.out.println("City list: " + founctionsForNotebook);
        }
        session.close();
        return founctionsForNotebookList;
    }

    @Override
    public FounctionsForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<FounctionsForNotebook> points1 = new ArrayList<FounctionsForNotebook>();
        if(session.createQuery("from FounctionsForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from FounctionsForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

