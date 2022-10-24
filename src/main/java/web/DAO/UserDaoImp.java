package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    @Override
    public List<User> printUser() {
        return entityManager.createQuery("select e from User e ", User.class).getResultList();
    }
    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        entityManager.remove(getById(id));
    }
    @Transactional
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
    @Transactional
    @Override
    public User getById(int id) {
        return entityManager.find(User.class,id);
    }
}
