package repository.impl;

import mapper.UserRoleMapper;
import model.UserRole;
import repository.IUserRoleRepository;

import java.util.List;

public class UserRoleRepositoryImpl extends BaseRepositoryImpl<UserRole> implements IUserRoleRepository {

    public static final String FIND_BY_USERNAME_PASSWORD = "select employees.fullname, employees.username, users.password, roles.name " +
            "from employees " +
            "inner join users " +
            "on employees.username = users.username " +
            "inner join userrole " +
            "on users.username = userrole.username " +
            "inner join roles " +
            "on userrole.roleid = roles.id " +
            "where employees.username = ? and users.password = ?;";

    @Override
    public UserRole findByUserNameAndPassword(String userName, String password) {
        List<UserRole> userRoleList = select(FIND_BY_USERNAME_PASSWORD, new UserRoleMapper(), userName, password);

        return userRoleList.isEmpty() ? null : userRoleList.get(0);
    }
}
