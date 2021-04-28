package web.hiber.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    void updateUser(Long id, User user);
}
