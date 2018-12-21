package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.DataForNotebook;

import java.util.ArrayList;
import java.util.List;

public class DataForNotebookDaoImpl implements Dao<DataForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(DataForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(DataForNotebook dataForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(dataForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("DataForNotebook successfully saved. DataForNotebook details: " + dataForNotebook);
    }

    @Override
    public void update(DataForNotebook dataForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dataForNotebook);
        logger.info("DataForNotebook successfully update. DataForNotebook details: " + dataForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        DataForNotebook dataForNotebook = (DataForNotebook) session.get(DataForNotebook.class, new Integer(id));

        if(dataForNotebook!=null){
            logger.info("DataForNotebook successfully removed. DataForNotebook details: " + dataForNotebook);
            session.beginTransaction();
            session.delete(dataForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from DataForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("DataForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public DataForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (DataForNotebook) session.get(DataForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<DataForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<DataForNotebook> dataForNotebookList = session.createQuery("from DataForNotebook").list();

        for(DataForNotebook dataForNotebook: dataForNotebookList){
            System.out.println("City list: " + dataForNotebook);
        }
        session.close();
        return dataForNotebookList;
    }

    @Override
    public DataForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<DataForNotebook> points1 = new ArrayList<DataForNotebook>();
        if(session.createQuery("from DataForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from DataForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

