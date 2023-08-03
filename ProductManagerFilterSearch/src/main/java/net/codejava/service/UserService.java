package net.codejava.service;

import net.codejava.exception.ResourceNotFoundException;
import net.codejava.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void removeUserById(Long id) throws ResourceNotFoundException;

    List<User> searchUserName(String firstName);
}
