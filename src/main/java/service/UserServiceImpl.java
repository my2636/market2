package service;

import entity.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User getById(UUID id) {
        return getById(id);
    }

    @Override
    public User getByNameOrAdd(String name) {
        return userRepository.getByNameOrAdd(name);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
