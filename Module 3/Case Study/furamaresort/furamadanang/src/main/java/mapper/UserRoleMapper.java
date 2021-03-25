package mapper;

import model.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper implements IRowMapper<UserRole> {
    @Override
    public UserRole mapRow(ResultSet resultSet) {
        UserRole userRole = new UserRole();
        try {
            userRole.setFullName(resultSet.getString("fullname"));
            userRole.setUserName(resultSet.getString("username"));
            userRole.setPassword(resultSet.getString("password"));
            userRole.setRole(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userRole;
    }
}
