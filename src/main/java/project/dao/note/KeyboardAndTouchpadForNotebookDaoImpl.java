package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.KeyboardAndTouchpadForNotebook;

import java.util.ArrayList;
import java.util.List;

public class KeyboardAndTouchpadForNotebookDaoImpl implements Dao<KeyboardAndTouchpadForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(KeyboardAndTouchpadForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(keyboardAndTouchpadForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("KeyboardAndTouchpadForNotebook successfully saved. KeyboardAndTouchpadForNotebook details: " + keyboardAndTouchpadForNotebook);
    }

    @Override
    public void update(KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(keyboardAndTouchpadForNotebook);
        logger.info("KeyboardAndTouchpadForNotebook successfully update. KeyboardAndTouchpadForNotebook details: " + keyboardAndTouchpadForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook = (KeyboardAndTouchpadForNotebook) session.get(KeyboardAndTouchpadForNotebook.class, new Integer(id));

        if(keyboardAndTouchpadForNotebook!=null){
            logger.info("KeyboardAndTouchpadForNotebook successfully removed. KeyboardAndTouchpadForNotebook details: " + keyboardAndTouchpadForNotebook);
            session.beginTransaction();
            session.delete(keyboardAndTouchpadForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from KeyboardAndTouchpadForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("KeyboardAndTouchpadForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public KeyboardAndTouchpadForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (KeyboardAndTouchpadForNotebook) session.get(KeyboardAndTouchpadForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<KeyboardAndTouchpadForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<KeyboardAndTouchpadForNotebook> keyboardAndTouchpadForNotebookList = session.createQuery("from KeyboardAndTouchpadForNotebook").list();

        for(KeyboardAndTouchpadForNotebook keyboardAndTouchpadForNotebook: keyboardAndTouchpadForNotebookList){
            System.out.println("City list: " + keyboardAndTouchpadForNotebook);
        }
        session.close();
        return keyboardAndTouchpadForNotebookList;
    }

    @Override
    public KeyboardAndTouchpadForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<KeyboardAndTouchpadForNotebook> points1 = new ArrayList<KeyboardAndTouchpadForNotebook>();
        if(session.createQuery("from KeyboardAndTouchpadForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from KeyboardAndTouchpadForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

