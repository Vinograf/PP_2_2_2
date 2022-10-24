package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;
@Service

public class UserServiceImp implements UserService {

    private final UserDao userDao;
    @Autowired

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public List<User> printUser() {
        return userDao.printUser();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }
    @Transactional
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }


}
