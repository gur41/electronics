package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.User;

import java.util.ArrayList;
import java.util.List;

    public class UserServiceImpl implements Service<User> {
        private Dao<User> userDao;

        public void setUserDao(Dao userDao) {
            this.userDao = userDao;
        }

        @Override
        @Transactional
        public void add(User user) {
            this.userDao.add(user);
        }

        @Override
        @Transactional
        public void update(User user) {
            this.userDao.update(user);
        }



        @Override
        @Transactional
        public void remove(int id) {
            this.userDao.remove(id);
        }

        @Override
        @Transactional
        public User getById(int id) {
            return this.userDao.getById(id);
        }

        @Override
        @Transactional
        public boolean getByLogin(String login) {
            return this.userDao.getByLogin(login);
        }

        @Override
        public User getByLoginP(String login) {
            return null;
        }


        @Override
        @Transactional
        public List<User> find(String name) {
            List list = new ArrayList();
            for (User purch:this.userDao.list()) {
                if(purch.getPassword().equals(name))
                    list.add(purch);
            }
            return list;
        }

        @Override
        @Transactional
        public List<User> list() {
            return this.userDao.list();
        }


    }

