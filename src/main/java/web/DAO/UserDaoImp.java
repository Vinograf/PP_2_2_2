package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Component
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    public UserDaoImp() {
    }

//    private List<User> users;
//
//    {
//        users = new ArrayList<User>();
//        users.add(new User(1, 11, "BMV"));
//        users.add(new User(2, 222, "AUDI"));
//        users.add(new User(3, 333, "HONDA"));
//        users.add(new User(4, 4444, "KIA"));
//        users.add(new User(5, 55555, "WW"));
//    }

    @Override
    public List<User> printUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class,id);
    }
}
