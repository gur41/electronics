package project.service;


import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.OrderUserElectronic;

import java.util.List;

public class OrderUserElectronicServiceImpl implements Service<OrderUserElectronic> {
    private Dao<OrderUserElectronic> orderUserElectronicDao;

    public void setOrderUserElectronicDao(Dao orderUserElectronicDao) {
        this.orderUserElectronicDao = orderUserElectronicDao;
    }


    @Override
    @Transactional
    public void add(OrderUserElectronic orderUserElectronic) {
        this.orderUserElectronicDao.add(orderUserElectronic);
    }

    @Override
    @Transactional
    public void update(OrderUserElectronic orderUserElectronic) {
        this.orderUserElectronicDao.update(orderUserElectronic);
    }

    @Override
    @Transactional
    public void remove(int id) {

    }

    @Override
    @Transactional
    public OrderUserElectronic getById(int id) {
        return this.orderUserElectronicDao.getById(id);
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.orderUserElectronicDao.getByLogin(login);
    }

    @Override
    @Transactional
    public OrderUserElectronic getByLoginP(String login) {
        return this.orderUserElectronicDao.getByLoginP(login);
    }

    @Override
    @Transactional
    public List<OrderUserElectronic> list() {
        return this.orderUserElectronicDao.list();
    }

    @Override
    @Transactional
    public List<OrderUserElectronic> find(String name) {
        return null;
    }
}
