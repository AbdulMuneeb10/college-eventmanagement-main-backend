package com.college.eventmanagement.service.impl;

import com.college.eventmanagement.entity.User;
import com.college.eventmanagement.repository.UserRepository;
import com.college.eventmanagement.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    @Override
    public User createUser(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered: " + user.getEmail());
        }
        return repo.save(user);
    }

    @Override
    public User updateUser(Long id, User updated) {
        User existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found: " + id));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setRole(updated.getRole());
        existing.setBranch(updated.getBranch());
        existing.setYear(updated.getYear());
        existing.setPhone(updated.getPhone());
        existing.setBio(updated.getBio());
        return repo.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}