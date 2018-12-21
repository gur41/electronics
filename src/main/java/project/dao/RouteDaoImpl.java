package project.dao;

import last.Route;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements DaoRoute<Route> {

    private static final Logger logger = LoggerFactory.getLogger(project.dao.RouteDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Route route) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(route);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Route route) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(route);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Route getById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return (Route) session.get(Route.class, new Integer(id));
        } finally {
            session.close();
        }
    }

    @Override
    public boolean getByLogin(String login) {
        return false;
    }

    @Override
    public List<Route> list() {
        Session session = sessionFactory.openSession();
        List<Route> userList = session.createQuery("from Route").list();
        session.close();
        return userList;
    }

    @Override
    public Route getByLoginP(String login) {
        Session session = sessionFactory.openSession();
        List<Route> route1 = new ArrayList<Route>();
        if(session.createQuery("from Route where name_of_route = '"+login+"'").iterate().hasNext())
            route1 = session.createQuery("from Route where name_of_route = '"+login+"'").list();
        logger.info("Point exist: ");
        session.close();
        if(route1.size() == 0)
            return null;
        else
            return route1.get(0);

    }

    @Override
    public List <Route> getRouteByEndStart(Integer start, Integer end) {

        Session session = sessionFactory.openSession();
        List<Route> route1 = new ArrayList<Route>();
        if(session.createQuery("from Route where end_point_of_route = '"+end+"' and start_point_of_route = '"+start+"'").iterate().hasNext())
            route1 = (List <Route>)session.createQuery("from Route where end_point_of_route = '"+end+"' and start_point_of_route = '"+start+"'").list();
        logger.info("Point exist: ");
        session.close();
        System.out.println("dao:  "+route1.size());
        if(route1.size() == 0)
            return null;
        else
            return route1;
    }
}
