package com.college.eventmanagement.service;

import com.college.eventmanagement.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User updated);
    void deleteUser(Long id);
}