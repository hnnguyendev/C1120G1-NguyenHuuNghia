package mapper;

import model.ServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeMapper implements IRowMapper<ServiceType> {
    @Override
    public ServiceType mapRow(ResultSet resultSet) {
        ServiceType serviceType = new ServiceType();
        try {
            serviceType.setId(resultSet.getLong("id"));
            serviceType.setServiceType(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceType;
    }
}
