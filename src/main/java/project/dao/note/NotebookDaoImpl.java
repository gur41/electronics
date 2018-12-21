package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.Notebook;

import java.util.ArrayList;
import java.util.List;

public class NotebookDaoImpl implements Dao<Notebook> {
    private static final Logger logger = LoggerFactory.getLogger(NotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Notebook notebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(notebook);
        session.getTransaction().commit();
        session.close();
        logger.info("Notebook successfully saved. Notebook details: " + notebook);
    }

    @Override
    public void update(Notebook notebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(notebook);
        logger.info("Notebook successfully update. Notebook details: " + notebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        Notebook notebook = (Notebook) session.get(Notebook.class, new Integer(id));

        if(notebook!=null){
            logger.info("Notebook successfully removed. Notebook details: " + notebook);
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from Notebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("Notebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public Notebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<Notebook> list() {
        Session session = sessionFactory.openSession();
        List<Notebook> notebookList = session.createQuery("from Notebook").list();

        for(Notebook notebook: notebookList){
            System.out.println("City list: " + notebook);
        }
        session.close();
        return notebookList;
    }

    @Override
    public Notebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<Notebook> points1 = new ArrayList<Notebook>();
        if(session.createQuery("from Notebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from Notebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

