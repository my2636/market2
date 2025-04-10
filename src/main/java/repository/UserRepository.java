package repository;

import entity.User;

import java.util.UUID;

public interface UserRepository {
    User getByNameOrAdd(String name);

    void deleteById(UUID id);
}
