package web.hiber.dao;

import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select User from User", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select User from User where id=" + id, User.class);
        return query.getSingleResult();
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.createQuery("delete from User where id=" + id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.persist(user);
    }
}
