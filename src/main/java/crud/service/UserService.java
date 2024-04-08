package crud.service;

import crud.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findUserById(Long id);
    void saveUser(User user);
    void updateUser(User userToBeUpdated);
    void removeUserById(Long id);
}
