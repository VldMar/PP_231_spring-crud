package crud.dao;

import crud.models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component("userDaoHibernate")
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return this.entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        this.entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User userToBeUpdated) {
        this.entityManager.merge(userToBeUpdated);
    }

    @Override
    @Transactional
    public void removeUserById(int id) {
        User user = this.findUserById(id);
        if (user == null) {
            throw new RuntimeException("Нет пользователя с индексом " + id);
        }
        entityManager.remove(user);
    }
}
