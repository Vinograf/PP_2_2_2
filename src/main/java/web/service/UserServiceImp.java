package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.DAO.UserDaoImp;
import web.model.User;

import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao = new UserDaoImp();
    @Override
    public List<User> printUser() {
        return userDao.printUser();
    }


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }


}
