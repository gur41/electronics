package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.InterfaceForNotebook;

import java.util.ArrayList;
import java.util.List;

public class InterfaceForNotebookDaoImpl implements Dao<InterfaceForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(InterfaceForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(InterfaceForNotebook interfaceForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(interfaceForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("InterfaceForNotebook successfully saved. InterfaceForNotebook details: " + interfaceForNotebook);
    }

    @Override
    public void update(InterfaceForNotebook interfaceForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(interfaceForNotebook);
        logger.info("InterfaceForNotebook successfully update. InterfaceForNotebook details: " + interfaceForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        InterfaceForNotebook interfaceForNotebook = (InterfaceForNotebook) session.get(InterfaceForNotebook.class, new Integer(id));

        if(interfaceForNotebook!=null){
            logger.info("InterfaceForNotebook successfully removed. InterfaceForNotebook details: " + interfaceForNotebook);
            session.beginTransaction();
            session.delete(interfaceForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from InterfaceForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("InterfaceForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public InterfaceForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (InterfaceForNotebook) session.get(InterfaceForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<InterfaceForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<InterfaceForNotebook> interfaceForNotebookList = session.createQuery("from InterfaceForNotebook").list();

        for(InterfaceForNotebook interfaceForNotebook: interfaceForNotebookList){
            System.out.println("City list: " + interfaceForNotebook);
        }
        session.close();
        return interfaceForNotebookList;
    }

    @Override
    public InterfaceForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<InterfaceForNotebook> points1 = new ArrayList<InterfaceForNotebook>();
        if(session.createQuery("from InterfaceForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from InterfaceForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

