package project.service;

import project.last.OrderUser;
import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class OrderUserServiceImpl implements Service<OrderUser> {
    private Dao<OrderUser> orderUserDao;

    public void setOrderUserDao(Dao orderUserDao) {
        this.orderUserDao = orderUserDao;
    }

    @Override
    @Transactional
    public void add(OrderUser orderUser) {
        this.orderUserDao.add(orderUser);
    }

    @Override
    @Transactional
    public void update(OrderUser orderUser) {
        this.orderUserDao.update(orderUser);
    }



    @Override
    @Transactional
    public void remove(int id) {
        this.orderUserDao.remove(id);
    }

    @Override
    @Transactional
    public OrderUser getById(int id) {
        return this.orderUserDao.getById(id);
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.orderUserDao.getByLogin(login);
    }

    @Override
    public OrderUser getByLoginP(String login) {
        return this.orderUserDao.getByLoginP(login);
    }


    @Override
    @Transactional
    public List<OrderUser> find(String name) {
        List list = new ArrayList();
        for (OrderUser purch:this.orderUserDao.list()) {
            if(purch.getIdUserOrder() == Integer.getInteger(name))
                list.add(purch);
        }
        return list;
    }

    @Override
    @Transactional
    public List<OrderUser> list() {
        return this.orderUserDao.list();
    }


}

