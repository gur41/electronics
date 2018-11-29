package project.service;

import last.Maps;
import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;

import java.util.List;

public class MapsServiceImpl implements Service<Maps> {
    private Dao<Maps> mapsDao;

    public void setMapsDao(Dao mapsDao) {
        this.mapsDao = mapsDao;
    }


    @Override
    @Transactional
    public void add(Maps maps) {
        this.mapsDao.add(maps);
    }

    @Override
    @Transactional
    public void update(Maps maps) {

    }

    @Override
    @Transactional
    public void remove(int id) {

    }

    @Override
    @Transactional
    public Maps getById(int id) {
        return null;
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.mapsDao.getByLogin(login);
    }

    @Override
    @Transactional
    public Maps getByLoginP(String login) {
        return this.mapsDao.getByLoginP(login);
    }

    @Override
    @Transactional
    public List<Maps> list() {
        return this.mapsDao.list();
    }

    @Override
    @Transactional
    public List<Maps> find(String name) {
        return null;
    }
}
