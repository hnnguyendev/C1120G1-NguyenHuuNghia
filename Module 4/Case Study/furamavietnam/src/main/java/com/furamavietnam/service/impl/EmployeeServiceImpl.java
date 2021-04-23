package com.furamavietnam.service.impl;

import com.furamavietnam.entity.AppRole;
import com.furamavietnam.entity.AppUser;
import com.furamavietnam.entity.Employee;
import com.furamavietnam.entity.UserRole;
import com.furamavietnam.repository.IEmployeeRepository;
import com.furamavietnam.service.IAppRoleService;
import com.furamavietnam.service.IAppUserService;
import com.furamavietnam.service.IEmployeeService;
import com.furamavietnam.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    IAppUserService appUserService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    IAppRoleService appRoleService;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByContaining(String txtSearch, Pageable pageable) {
        return employeeRepository.findByContaining(txtSearch, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        AppUser appUser = new AppUser();
        appUser.setUsername(employee.getAppUser().getUsername());
        appUser.setEncryptedPassword(bCryptPasswordEncoder.encode("123123"));
        appUser.setEnabled(true);
        appUserService.save(appUser);

        if (employee.getId() == null) {
            AppRole appRole = appRoleService.findByRoleName("ROLE_ADMIN");
            UserRole userRole = new UserRole();
            userRole.setAppRole(appRole);
            userRole.setAppUser(appUser);
            userRoleService.save(userRole);
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        AppUser appUser = appUserService.findByUsername(employee.getAppUser().getUsername());
        appUser.setEnabled(false);
        appUserService.save(appUser);

        employeeRepository.deleteById(id);

        return employee;
    }
}
