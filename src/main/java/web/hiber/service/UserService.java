package web.hiber.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    User getUserById(String id);
    void deleteUserById(String id);
    void updateUser(User user);
    User getUserByName(String s);
}
