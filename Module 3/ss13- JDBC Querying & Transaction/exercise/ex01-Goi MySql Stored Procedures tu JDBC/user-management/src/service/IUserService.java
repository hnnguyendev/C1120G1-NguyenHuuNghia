package service;

import model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    List<User> findAllSP();

    User findById(int id);

    void save(User user);

    void update(int id, User user);

    void updateSP(int id, User user);

    void remove(int id);

    void removeSP(int id);

    List<User> findByCountry(String txtSearch);

}
