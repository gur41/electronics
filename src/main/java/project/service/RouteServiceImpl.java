package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import last.Route;
import project.dao.DaoRoute;


import java.util.List;

public class RouteServiceImpl implements ServiceRoute<Route> {
    private DaoRoute<Route> routeDao;

    public void setRouteDao(DaoRoute routeDao) {
        this.routeDao = routeDao;
    }



    @Override
    @Transactional
    public void add(Route route) {
        this.routeDao.add(route);
    }


    @Override
    @Transactional
    public void update(Route route) {

    }

    @Override
    @Transactional
    public void remove(int id) {

    }

    @Override
    @Transactional
    public Route getById(int id) {
        return null;
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return false;
    }

    @Override
    public Route getByLoginP(String login) {
        return this.routeDao.getByLoginP(login);
    }

    @Override
    @Transactional
    public List<Route> list() {
        return null;
    }

    @Override
    @Transactional
    public List<Route> find(String name) {
        return null;
    }

    @Override
    public List<Route> getRouteByEndStart(Integer start, Integer end) {
        return this.routeDao.getRouteByEndStart(start, end);
    }
}
