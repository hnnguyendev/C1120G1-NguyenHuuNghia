package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepositoryImpl;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(int id, User user) {
        userRepository.update(id, user);
    }

    @Override
    public void remove(int id) {
        userRepository.remove(id);
    }

    @Override
    public List<User> findByCountry(String txtSearch) {
        return userRepository.findByCountry(txtSearch);
    }
}
