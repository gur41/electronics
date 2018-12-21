package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.ProcessorForNotebook;

import java.util.ArrayList;
import java.util.List;

public class ProcessorForNotebookDaoImpl implements Dao<ProcessorForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(ProcessorForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(ProcessorForNotebook processorForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(processorForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("ProcessorForNotebook successfully saved. ProcessorForNotebook details: " + processorForNotebook);
    }

    @Override
    public void update(ProcessorForNotebook processorForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(processorForNotebook);
        logger.info("ProcessorForNotebook successfully update. ProcessorForNotebook details: " + processorForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        ProcessorForNotebook processorForNotebook = (ProcessorForNotebook) session.get(ProcessorForNotebook.class, new Integer(id));

        if(processorForNotebook!=null){
            logger.info("ProcessorForNotebook successfully removed. ProcessorForNotebook details: " + processorForNotebook);
            session.beginTransaction();
            session.delete(processorForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from ProcessorForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("ProcessorForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public ProcessorForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (ProcessorForNotebook) session.get(ProcessorForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<ProcessorForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<ProcessorForNotebook> processorForNotebookList = session.createQuery("from ProcessorForNotebook").list();

        for(ProcessorForNotebook processorForNotebook: processorForNotebookList){
            System.out.println("City list: " + processorForNotebook);
        }
        session.close();
        return processorForNotebookList;
    }

    @Override
    public ProcessorForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<ProcessorForNotebook> points1 = new ArrayList<ProcessorForNotebook>();
        if(session.createQuery("from ProcessorForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from ProcessorForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

