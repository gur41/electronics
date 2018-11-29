package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import last.Points;

import java.util.List;

public class PointsServiceImpl implements Service<Points> {
    private Dao<Points> pointsDao;

    public void setPointsDao(Dao pointsDao) {
        this.pointsDao = pointsDao;
    }


    @Override
    @Transactional
    public void add(Points points) {
        this.pointsDao.add(points);
    }

    @Override
    @Transactional
    public void update(Points points) {

    }

    @Override
    @Transactional
    public void remove(int id) {

    }

    @Override
    @Transactional
    public Points getById(int id) {
        return null;
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.pointsDao.getByLogin(login);
    }

    @Override
    @Transactional
    public Points getByLoginP(String login) {
        return this.pointsDao.getByLoginP(login);
    }

    @Override
    @Transactional
    public List<Points> list() {
        return this.pointsDao.list();
    }

    @Override
    @Transactional
    public List<Points> find(String name) {
        return null;
    }
}
