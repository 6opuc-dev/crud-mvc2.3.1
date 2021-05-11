package web.hiber.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void addUser(User user);
    User getUserById(String id);
    void deleteUserById(String id);
    void updateUser(User user);
    User getUserByName(String s);
}
