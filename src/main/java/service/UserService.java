package service;

import entity.User;

import java.util.UUID;

public interface UserService {

    User getById(UUID id);

    User getByNameOrAdd(String name);

    void deleteById(UUID id);
}
