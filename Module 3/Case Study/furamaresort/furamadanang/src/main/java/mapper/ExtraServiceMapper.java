package mapper;

import model.ExtraService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtraServiceMapper implements IRowMapper<ExtraService> {
    @Override
    public ExtraService mapRow(ResultSet resultSet) {
        ExtraService extraService = new ExtraService();
        try {
            extraService.setId(resultSet.getLong("id"));
            extraService.setName(resultSet.getString("name"));
            extraService.setCost(resultSet.getDouble("cost"));
            extraService.setUnit(resultSet.getInt("unit"));
            extraService.setStatus(resultSet.getString("status"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return extraService;
    }
}
