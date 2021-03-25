package repository.impl;

import mapper.UserMapper;
import model.User;
import repository.IUserRepository;

import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements IUserRepository {

    public static final String SELECT_ALL_USERS = "select * from users;";
    public static final String FIND_AVAILABLE = "select users.username, users.password from users " +
            "left join employees on users.username = employees.username where employees.username is null;";
    public static final String SELECT_USER_BY_USERNAME = "select * from users where username = ?;";

    @Override
    public List<User> findAll() {
        return select(SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public List<User> findAvailable() {
        return select(FIND_AVAILABLE, new UserMapper());
    }

    @Override
    public User findByUsername(String username) {
        List<User> userList = select(SELECT_USER_BY_USERNAME, new UserMapper(), username);

        return userList.isEmpty() ? null : userList.get(0);
    }


}
