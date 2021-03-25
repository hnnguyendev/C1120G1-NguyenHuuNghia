package mapper;

import model.RentType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentTypeMapper implements IRowMapper<RentType> {
    @Override
    public RentType mapRow(ResultSet resultSet) {
        RentType rentType = new RentType();
        try {
            rentType.setId(resultSet.getLong("id"));
            rentType.setRentType(resultSet.getString("name"));
            rentType.setCost(resultSet.getDouble("cost"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentType;
    }
}
