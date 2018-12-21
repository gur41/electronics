package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.ConstructionForNotebook;

import java.util.ArrayList;
import java.util.List;

public class ConstructionForNotebookDaoImpl implements Dao<ConstructionForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(ConstructionForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(ConstructionForNotebook constructionForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(constructionForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("ConstructionForNotebook successfully saved. ConstructionForNotebook details: " + constructionForNotebook);
    }

    @Override
    public void update(ConstructionForNotebook constructionForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(constructionForNotebook);
        logger.info("ConstructionForNotebook successfully update. ConstructionForNotebook details: " + constructionForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        ConstructionForNotebook constructionForNotebook = (ConstructionForNotebook) session.get(ConstructionForNotebook.class, new Integer(id));

        if(constructionForNotebook!=null){
            logger.info("ConstructionForNotebook successfully removed. ConstructionForNotebook details: " + constructionForNotebook);
            session.beginTransaction();
            session.delete(constructionForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from ConstructionForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("ConstructionForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public ConstructionForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (ConstructionForNotebook) session.get(ConstructionForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<ConstructionForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<ConstructionForNotebook> constructionForNotebookList = session.createQuery("from ConstructionForNotebook").list();

        for(ConstructionForNotebook constructionForNotebook: constructionForNotebookList){
            System.out.println("City list: " + constructionForNotebook);
        }
        session.close();
        return constructionForNotebookList;
    }

    @Override
    public ConstructionForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<ConstructionForNotebook> points1 = new ArrayList<ConstructionForNotebook>();
        if(session.createQuery("from ConstructionForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from ConstructionForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

