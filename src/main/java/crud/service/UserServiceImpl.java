package crud.service;

import crud.dao.UserDao;
import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoHibernate") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    @Override
    public User findUserById(int id) {
        return this.userDao.findUserById(id);
    }

    @Override
    public void saveUser(User user) {
        this.userDao.saveUser(user);
    }

    @Override
    public void updateUser(User userToBeUpdated) {
        this.userDao.updateUser(userToBeUpdated);
    }

    @Override
    public void removeUserById(int id) {
        this.userDao.removeUserById(id);
    }
}
