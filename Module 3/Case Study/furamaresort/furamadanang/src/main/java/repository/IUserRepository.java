package repository;

import model.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();

    List<User> findAvailable();

    User findByUsername(String username);
    
}
