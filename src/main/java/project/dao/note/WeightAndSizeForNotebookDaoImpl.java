package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.WeightAndSizeForNotebook;

import java.util.ArrayList;
import java.util.List;

public class WeightAndSizeForNotebookDaoImpl implements Dao<WeightAndSizeForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(WeightAndSizeForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(WeightAndSizeForNotebook weightAndSizeForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(weightAndSizeForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("WeightAndSizeForNotebook successfully saved. WeightAndSizeForNotebook details: " + weightAndSizeForNotebook);
    }

    @Override
    public void update(WeightAndSizeForNotebook weightAndSizeForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(weightAndSizeForNotebook);
        logger.info("WeightAndSizeForNotebook successfully update. WeightAndSizeForNotebook details: " + weightAndSizeForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        WeightAndSizeForNotebook weightAndSizeForNotebook = (WeightAndSizeForNotebook) session.get(WeightAndSizeForNotebook.class, new Integer(id));

        if(weightAndSizeForNotebook!=null){
            logger.info("WeightAndSizeForNotebook successfully removed. WeightAndSizeForNotebook details: " + weightAndSizeForNotebook);
            session.beginTransaction();
            session.delete(weightAndSizeForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from WeightAndSizeForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("WeightAndSizeForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public WeightAndSizeForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (WeightAndSizeForNotebook) session.get(WeightAndSizeForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<WeightAndSizeForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<WeightAndSizeForNotebook> weightAndSizeForNotebookList = session.createQuery("from WeightAndSizeForNotebook").list();

        for(WeightAndSizeForNotebook weightAndSizeForNotebook: weightAndSizeForNotebookList){
            System.out.println("City list: " + weightAndSizeForNotebook);
        }
        session.close();
        return weightAndSizeForNotebookList;
    }

    @Override
    public WeightAndSizeForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<WeightAndSizeForNotebook> points1 = new ArrayList<WeightAndSizeForNotebook>();
        if(session.createQuery("from WeightAndSizeForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from WeightAndSizeForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

