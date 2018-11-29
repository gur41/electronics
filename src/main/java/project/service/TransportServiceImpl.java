package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import last.Transport;
import project.dao.DaoTransport;

import java.util.List;

public class TransportServiceImpl implements ServiceTransport<Transport>, Service<Transport>  {

    private DaoTransport<Transport> transportDaoTransport;
    private Dao<Transport> transportDao;


    public void setTransportDao(Dao<Transport> transportDao) {
        this.transportDao = transportDao;
    }

    public void setTransportDaoTransport(DaoTransport<Transport> transportDaoTransport) {
        this.transportDaoTransport = transportDaoTransport;
    }

    @Override
    @Transactional
    public void add(Transport pransport) {
        this.transportDao.add(pransport);
    }

    @Override
    @Transactional
    public void update(Transport pransport) {

    }

    @Override
    @Transactional
    public void remove(int id) {

    }

    @Override
    @Transactional
    public Transport getById(int id) {
        return null;
    }

    @Override
    @Transactional
    public boolean getByLogin(String login) {
        return this.transportDao.getByLogin(login);
    }

    @Override
    public Transport getByLoginP(String login) {
        return null;
    }

    @Override
    @Transactional
    public List<Transport> list() {
        return this.transportDao.list();
    }

    @Override
    @Transactional
    public List<Transport> find(String name) {
        return null;
    }

    @Override
    @Transactional
    public Transport getByTransport(Transport transport) {
        return this.transportDaoTransport.getByTransport(transport);
    }
}
