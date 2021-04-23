package mapper;

import model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements IRowMapper<Position> {

    @Override
    public Position mapRow(ResultSet resultSet) {
        Position position = new Position();
        try {
            position.setId(resultSet.getLong("id"));
            position.setPosition(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return position;
    }
}
