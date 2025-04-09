package repository;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    List<User> users = new ArrayList<>(0);

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
    public User getByNameOrAdd(String name) {
        if (users.isEmpty()) {
            User user = new User(name);
            users.add(user);
            System.out.println("Добавлен пользователь: " + name + "\nID: " + user.getId());
        }
        return users
                .stream()
                .filter(x -> name.equals(x.getName()))
                .findFirst()
                .orElse(null);

    }

    @Override
    public void deleteById(UUID id) {
        users.removeIf(x -> id.equals(x.getId()));
    }
}
