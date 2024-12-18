package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void removeUserById(long id);
    List<User> getUsers();
    User getUser(long id);
}
