package service.impl;

import model.UserRole;
import repository.IUserRoleRepository;
import repository.impl.UserRoleRepositoryImpl;
import service.IUserRoleService;

public class UserRoleServiceImpl implements IUserRoleService {

    IUserRoleRepository userRoleRepository = new UserRoleRepositoryImpl();

    @Override
    public UserRole findByUsernameAndPassword(String userName, String password) {
        return userRoleRepository.findByUserNameAndPassword(userName, password);
    }
}
