package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.GraphicsForNotebook;

import java.util.ArrayList;
import java.util.List;

public class GraphicsForNotebookDaoImpl implements Dao<GraphicsForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(GraphicsForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(GraphicsForNotebook graphicsForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(graphicsForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("GraphicsForNotebook successfully saved. GraphicsForNotebook details: " + graphicsForNotebook);
    }

    @Override
    public void update(GraphicsForNotebook graphicsForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(graphicsForNotebook);
        logger.info("GraphicsForNotebook successfully update. GraphicsForNotebook details: " + graphicsForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        GraphicsForNotebook graphicsForNotebook = (GraphicsForNotebook) session.get(GraphicsForNotebook.class, new Integer(id));

        if(graphicsForNotebook!=null){
            logger.info("GraphicsForNotebook successfully removed. GraphicsForNotebook details: " + graphicsForNotebook);
            session.beginTransaction();
            session.delete(graphicsForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from GraphicsForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("GraphicsForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public GraphicsForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (GraphicsForNotebook) session.get(GraphicsForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<GraphicsForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<GraphicsForNotebook> graphicsForNotebookList = session.createQuery("from GraphicsForNotebook").list();

        for(GraphicsForNotebook graphicsForNotebook: graphicsForNotebookList){
            System.out.println("City list: " + graphicsForNotebook);
        }
        session.close();
        return graphicsForNotebookList;
    }

    @Override
    public GraphicsForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<GraphicsForNotebook> points1 = new ArrayList<GraphicsForNotebook>();
        if(session.createQuery("from GraphicsForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from GraphicsForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

