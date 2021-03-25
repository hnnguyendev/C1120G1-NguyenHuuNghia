package mapper;

import model.Contract;
import repository.ICustomerRepository;
import repository.IEmployeeRepository;
import repository.IServiceRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.EmployeeRepositoryImpl;
import repository.impl.ServiceRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractMapper implements IRowMapper<Contract> {

    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    IServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public Contract mapRow(ResultSet resultSet) {
        Contract contract = new Contract();
        try {
            contract.setId(resultSet.getLong("id"));
            contract.setStartDay(resultSet.getDate("startdate"));
            contract.setEndDay(resultSet.getDate("enddate"));
            contract.setDeposit(resultSet.getDouble("deposit"));
            contract.setTotalPay(resultSet.getDouble("totalpay"));
            contract.setEmployee(employeeRepository.findById(resultSet.getLong("employeeid")));
            contract.setCustomer(customerRepository.findById(resultSet.getLong("customerid")));
            contract.setService(serviceRepository.findById(resultSet.getLong("serviceid")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }
}
