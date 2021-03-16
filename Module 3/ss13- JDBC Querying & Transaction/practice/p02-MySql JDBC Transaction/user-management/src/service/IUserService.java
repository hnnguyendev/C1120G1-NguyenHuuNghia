package service;

import model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(int id, User user);

    void remove(int id);

    List<User> findByCountry(String txtSearch);

    void addUserTransaction(User user, int[] permission);

}
