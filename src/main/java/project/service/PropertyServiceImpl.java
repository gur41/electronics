package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.clasess.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyServiceImpl implements Service<Property> {
    private Dao<Property> userDao;

    public void setPropertyDao(Dao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(Property user) {
        this.userDao.add(user);
    }

    @Override
    @Transactional
    public void update(Property user) {
        this.userDao.update(user);
    }



    @Override
    @Transactional
    public void remove(int id) {
        this.userDao.remove(id);
    }

    @Override
    @Transactional
    public Property getById(int id) {
        return this.userDao.getById(id);
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.userDao.getByLogin(login);
    }

    @Override
    public Property getByLoginP(String login) {
        return null;
    }


    @Override
    @Transactional
    public List<Property> find(String name) {
        List list = new ArrayList();
        /*for (Property purch:this.userDao.list()) {
            if(purch.getPassword().equals(name))
                list.add(purch);
        }*/
        return list;
    }

    @Override
    @Transactional
    public List<Property> list() {
        return this.userDao.list();
    }


}

