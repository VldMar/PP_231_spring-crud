package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);
    void editUser(User user);
    void addUser(User user);
    void removeUserById(int id);
}
