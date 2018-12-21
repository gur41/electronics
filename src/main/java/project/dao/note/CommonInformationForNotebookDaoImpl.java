package project.dao.note;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.dao.Dao;
import project.model.note.CommonInformationForNotebook;

import java.util.ArrayList;
import java.util.List;

public class CommonInformationForNotebookDaoImpl implements Dao<CommonInformationForNotebook> {
    private static final Logger logger = LoggerFactory.getLogger(CommonInformationForNotebookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CommonInformationForNotebook commonInformationForNotebook) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(commonInformationForNotebook);
        session.getTransaction().commit();
        session.close();
        logger.info("CommonInformationForNotebook successfully saved. CommonInformationForNotebook details: " + commonInformationForNotebook);
    }

    @Override
    public void update(CommonInformationForNotebook commonInformationForNotebook) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(commonInformationForNotebook);
        logger.info("CommonInformationForNotebook successfully update. CommonInformationForNotebook details: " + commonInformationForNotebook);
    }

    @Override
    public void remove(int id) {

        Session session = sessionFactory.openSession();
        CommonInformationForNotebook commonInformationForNotebook = (CommonInformationForNotebook) session.get(CommonInformationForNotebook.class, new Integer(id));

        if(commonInformationForNotebook!=null){
            logger.info("CommonInformationForNotebook successfully removed. CommonInformationForNotebook details: " + commonInformationForNotebook);
            session.beginTransaction();
            session.delete(commonInformationForNotebook);
            session.getTransaction().commit();
        }
        session.close();

    }

    @Override
    public boolean getByLogin(String login) {

        Session session = sessionFactory.openSession();

        if(session.createQuery("from CommonInformationForNotebook where login = '"+login+"'").iterate().hasNext()){
            logger.info("CommonInformationForNotebook exist: ");
            session.close();
            return true;
        }
        else{
            session.close();
            return false;
        }

    }


    @Override
    public CommonInformationForNotebook getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (CommonInformationForNotebook) session.get(CommonInformationForNotebook.class, new Integer(id));
        } finally {
            session.close();
        }
    }







    @Override
    @SuppressWarnings("unchecked")
    public List<CommonInformationForNotebook> list() {
        Session session = sessionFactory.openSession();
        List<CommonInformationForNotebook> commonInformationForNotebookList = session.createQuery("from CommonInformationForNotebook").list();

        for(CommonInformationForNotebook commonInformationForNotebook: commonInformationForNotebookList){
            System.out.println("City list: " + commonInformationForNotebook);
        }
        session.close();
        return commonInformationForNotebookList;
    }

    @Override
    public CommonInformationForNotebook getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<CommonInformationForNotebook> points1 = new ArrayList<CommonInformationForNotebook>();
        if(session.createQuery("from CommonInformationForNotebook where login = '"+login+"'").iterate().hasNext())
            points1 = session.createQuery("from CommonInformationForNotebook where login = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(points1.size() == 0)
            return null;
        else
            return points1.get(0);
    }
}

