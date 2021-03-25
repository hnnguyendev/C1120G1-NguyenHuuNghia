package mapper;

import model.CustomerType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTypeMapper implements IRowMapper<CustomerType> {
    @Override
    public CustomerType mapRow(ResultSet resultSet) {
        CustomerType customerType = new CustomerType();
        try {
            customerType.setId(resultSet.getLong("id"));
            customerType.setCustomerType(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerType;
    }
}
