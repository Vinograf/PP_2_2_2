package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> printUser();
    void add(User user);
    void deleteById(int id);
    void edit(User user);

    User getById(int id);
}
