package service;

import model.UserRole;

public interface IUserRoleService {

    UserRole findByUsernameAndPassword(String userName, String password);
}
