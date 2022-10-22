package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> printUser();

    void add(User user);

    void deleteById(int id);

    void edit(User user);

    User getById(int id);
}
