package web.hiber.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE id=" + id, User.class);
        return query.getSingleResult();
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastname(user.getLastname());
        userToBeUpdated.setEmail(user.getEmail());
        addUser(userToBeUpdated);
    }
}
