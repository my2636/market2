package repository;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository{
    List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public User getById(UUID id) {
        return users
                .stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Пользователь с ID " + id + " не найден"));
    }

    @Override
    public User getByName(String name) {
        return users
                .stream()
                .filter(x -> name.equals(x.getName()))
                .findFirst()
                .orElse();
    }

    @Override
    public void deleteById(UUID id) {
        users.removeIf(x -> id.equals(x.getId()));
    }
}
