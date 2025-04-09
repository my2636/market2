package service;

import entity.User;

import java.util.UUID;

public interface UserService {
    void add(User user);
    User getById(UUID id);
    User getByNameOrAdd(String name);
    void deleteById(UUID id);
}
