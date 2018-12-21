package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.ComplectationForNotebook;

import java.util.ArrayList;
import java.util.List;

public class ComplectationForNotebookDaoImpl implements Dao<ComplectationForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(ComplectationForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(ComplectationForNotebook complectationForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(complectationForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("ComplectationForNotebook successfully saved. ComplectationForNotebook details: " + complectationForNotebook);
    }

    @Override
    public void update(ComplectationForNotebook complectationForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(complectationForNotebook);
        logger.info("ComplectationForNotebook successfully update. ComplectationForNotebook details: " + complectationForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        ComplectationForNotebook complectationForNotebook = (ComplectationForNotebook) session.get(ComplectationForNotebook.class, new Integer(id));

        if(complectationForNotebook!=null){
            logger.info("ComplectationForNotebook successfully removed. ComplectationForNotebook details: " + complectationForNotebook);
            session.beginTransaction();
            session.delete(complectationForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from ComplectationForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("ComplectationForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public ComplectationForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (ComplectationForNotebook) session.get(ComplectationForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<ComplectationForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<ComplectationForNotebook> complectationForNotebookList = session.createQuery("from ComplectationForNotebook").list();

        for(ComplectationForNotebook complectationForNotebook: complectationForNotebookList){
            System.out.println("City list: " + complectationForNotebook);
        }
        session.close();
        return complectationForNotebookList;
    }

    @Override
    public ComplectationForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<ComplectationForNotebook> points1 = new ArrayList<ComplectationForNotebook>();
        if(session.createQuery("from ComplectationForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from ComplectationForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

