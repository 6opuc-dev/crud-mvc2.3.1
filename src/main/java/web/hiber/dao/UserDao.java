package web.hiber.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void addUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    void updateUser(User user);
}
