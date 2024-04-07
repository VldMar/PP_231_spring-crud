package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User findUserById(int id);
    void saveUser(User user);
    void updateUser(User userToBeUpdated);
    void removeUserById(int id);
}
