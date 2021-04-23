package mapper;

import model.Customer;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements IRowMapper<Customer> {

    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public Customer mapRow(ResultSet resultSet) {
        Customer customer = new Customer();
        try {
            customer.setId(resultSet.getLong("id"));
            customer.setCustomerCode(resultSet.getString("customercode"));
            customer.setFullName(resultSet.getString("fullname"));
            customer.setBirthday(resultSet.getDate("birthday"));
            customer.setGender(resultSet.getInt("gender"));
            customer.setIdNumber(resultSet.getString("idnumber"));
            customer.setPhoneNumber(resultSet.getString("phonenumber"));
            customer.setEmail(resultSet.getString("email"));
            customer.setAddress(resultSet.getString("address"));
            customer.setFlag(resultSet.getInt("flag"));
            customer.setCustomerType(customerTypeRepository.findById(resultSet.getLong("customertypeid")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
