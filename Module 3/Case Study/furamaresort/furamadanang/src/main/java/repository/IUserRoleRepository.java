package repository;

import model.UserRole;

import java.util.List;

public interface IUserRoleRepository {

    UserRole findByUserNameAndPassword(String userName, String password);
}
